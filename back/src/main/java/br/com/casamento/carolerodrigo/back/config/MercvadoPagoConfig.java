package br.com.casamento.carolerodrigo.back.config;

import com.mercadopago.MercadoPagoConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MercvadoPagoConfig {

    @Value("${mercadopago.accesstoken}")
    private String mercadoPagoAccessToken;

    @PostConstruct
    private void mercadoPagoConfig() {
        MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
    }

}
