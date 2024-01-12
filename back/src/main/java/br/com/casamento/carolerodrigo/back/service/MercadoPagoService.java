package br.com.casamento.carolerodrigo.back.service;

import br.com.casamento.carolerodrigo.back.model.Gift;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoService {

    public String createPreferenceForGift(Gift gift) {
        try {
            PreferenceItemRequest itemRequest =
                    PreferenceItemRequest.builder()
                            .id(gift.getId().toString())
                            .title(gift.getPresent().getName())
                            .description("")
                            .pictureUrl("")
                            .categoryId("presentes")
                            .quantity(2)
                            .currencyId("BRL")
                            .unitPrice(BigDecimal.valueOf(gift.getPresent().getValue()))
                            .build();
            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items).build();
            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);

            return preference.getId();
        } catch (Exception e) {
            return null;
        }
    }

}
