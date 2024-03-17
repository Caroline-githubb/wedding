package br.com.casamento.carolerodrigo.back.service;

import br.com.casamento.carolerodrigo.back.model.Gift;
import br.com.casamento.carolerodrigo.back.repository.GiftRepository;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.preference.Preference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MercadoPagoService {

    private final GiftRepository giftRepository;

    public String createPreferenceForGift(Gift gift) {
        try {
            PreferenceItemRequest itemRequest =
                    PreferenceItemRequest.builder()
                            .id(gift.getId().toString())
                            .title(gift.getPresent().getName())
                            .description("")
                            .pictureUrl("")
                            .categoryId("presentes")
                            .quantity(1)
                            .currencyId("BRL")
                            .unitPrice(BigDecimal.valueOf(gift.getPresent().getValue()))
                            .build();
            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .externalReference(gift.getId().toString())
                    .build();
            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);

            return preference.getId();
        } catch (Exception e) {
            return null;
        }
    }

    public Payment getPayment(long id) {
        try {
            PaymentClient client = new PaymentClient();
            return client.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isPaymentPayed(Payment payment) {
        return "approved".equals(payment.getStatus());
    }

}
