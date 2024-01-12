package br.com.casamento.carolerodrigo.back.controller;

import br.com.casamento.carolerodrigo.back.dto.GiftResponse;
import br.com.casamento.carolerodrigo.back.model.Gift;
import br.com.casamento.carolerodrigo.back.model.Present;
import br.com.casamento.carolerodrigo.back.repository.GiftRepository;
import br.com.casamento.carolerodrigo.back.repository.PresentRepository;
import br.com.casamento.carolerodrigo.back.service.MercadoPagoService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/gift")
@RequiredArgsConstructor
public class GiftController {

    private final PresentRepository presentRepository;
    private final GiftRepository giftRepository;
    private final MercadoPagoService mercadoPagoService;

    @GetMapping("/available")
    public ResponseEntity<Present[]> getAllAvailable() {
        var gifts = presentRepository.findAllAvailable();
        if (ArrayUtils.isEmpty(gifts)) {
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

}
