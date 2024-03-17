package br.com.casamento.carolerodrigo.back.service;

import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("deploy")
public class MercadoPagoWebhookValidatorServiceDeploy implements MercadoPagoWebhookValidatorService {

    @Value("${mercadopago.assinatura}")
    private String secret;

    @Override
    public boolean isValidSignature(long id, String assinatura, String requestId) {
        String[] arrSign = StringUtils.split(assinatura, ",");

        if (arrSign.length < 2) return false;

        String ts = StringUtils.replace(arrSign[0], "ts=", "");
        String hash = StringUtils.replace(arrSign[1], "v1=", "");

        String template = String.format("id:%s;request-id:%s;ts:%s;", id, requestId, ts);
        String cyphedSignature = new HmacUtils("HmacSHA256", this.secret).hmacHex(template);

        return cyphedSignature.equals(hash);
    }
}
