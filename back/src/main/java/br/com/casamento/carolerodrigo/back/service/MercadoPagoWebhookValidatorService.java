package br.com.casamento.carolerodrigo.back.service;

public interface MercadoPagoWebhookValidatorService {

    boolean isValidSignature(long id, String assinatura, String requestId);

}

