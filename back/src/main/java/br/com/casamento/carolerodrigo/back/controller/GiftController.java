package br.com.casamento.carolerodrigo.back.controller;

import br.com.casamento.carolerodrigo.back.dto.GiftResponse;
import br.com.casamento.carolerodrigo.back.dto.MercadoPagoWebHookEntity;
import br.com.casamento.carolerodrigo.back.model.Gift;
import br.com.casamento.carolerodrigo.back.model.Present;
import br.com.casamento.carolerodrigo.back.repository.GiftRepository;
import br.com.casamento.carolerodrigo.back.repository.PresentRepository;
import br.com.casamento.carolerodrigo.back.service.MercadoPagoService;
import br.com.casamento.carolerodrigo.back.service.MercadoPagoWebhookValidatorService;
import com.mercadopago.resources.payment.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/gift")
@RequiredArgsConstructor
@Slf4j
public class GiftController {

    private final PresentRepository presentRepository;
    private final GiftRepository giftRepository;
    private final MercadoPagoService mercadoPagoService;
    private final MercadoPagoWebhookValidatorService mercadoPagoWebhookValidatorService;

    @GetMapping("/available")
    public ResponseEntity<List<Present>> getAllAvailable() {
        var gifts = presentRepository.findAllAvailable();
        if (gifts == null || gifts.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(gifts);
        }
    }

    @PostMapping("/")
    public ResponseEntity<GiftResponse> gift(@RequestBody Gift gift) {
        gift.setId(UUID.randomUUID());
        String preference = mercadoPagoService.createPreferenceForGift(gift);
        gift.setMercado_pago_preference(preference);
        this.giftRepository.save(gift);
        return ResponseEntity.ok(GiftResponse.builder()
                .preferenceId(preference)
                .build());
    }

    @PostMapping("/webhook")
    public ResponseEntity<?> giftSucess(@RequestHeader("x-signature") String assinatura,
                                        @RequestHeader("x-request-id") String requestId,
                                        @RequestBody MercadoPagoWebHookEntity data) {

        long id = Optional.ofNullable(data)
                .map(MercadoPagoWebHookEntity::getData)
                .map(MercadoPagoWebHookEntity.MercadoPagoData::getId)
                .orElse(0L);

        if (!mercadoPagoWebhookValidatorService.isValidSignature(id, assinatura, requestId))
            return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.UNAUTHORIZED.value())).build();

        Payment payment = mercadoPagoService.getPayment(id);
        if (payment != null) {
            giftRepository.findByItem(UUID.fromString(payment.getExternalReference())).ifPresent(gift -> {
                if (mercadoPagoService.isPaymentPayed(payment))
                    gift.setStatus("payed");

                gift.setMercado_pago_id_payment(id);

                giftRepository.save(gift);
            });
        }
        return ResponseEntity.ok().build();
    }

}
