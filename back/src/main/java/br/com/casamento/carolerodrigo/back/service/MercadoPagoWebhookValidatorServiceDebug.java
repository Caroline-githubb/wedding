package br.com.casamento.carolerodrigo.back.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!deploy")
public class MercadoPagoWebhookValidatorServiceDebug implements MercadoPagoWebhookValidatorService {
    @Override
    public boolean isValidSignature(long id, String assinatura, String requestId) {
        return true;
    }
}
