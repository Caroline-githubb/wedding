package br.com.casamento.carolerodrigo.back.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MercadoPagoConfig {

    @Value("${mercadopago.accesstoken}")
    private String mercadoPagoAccessToken;

    @PostConstruct
    private void mercadoPagoConfig() {
        com.mercadopago.MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
    }

}
