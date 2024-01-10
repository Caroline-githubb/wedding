package br.com.casamento.carolerodrigo.back.config;

import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;

@Configuration
public class JWTConfig {

    private final static String RSA = "RSA";

    private String privateKeyValue;

    @Bean
    public Algorithm algorithm() {
        var rsaPrivateKey = rsaPrivateKey();
        var rsaPublicKey = rsaPublicKey(rsaPrivateKey);

        return Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
    }

    private RSAPrivateKey rsaPrivateKey() {
        try {
            if (StringUtils.isBlank(privateKeyValue)) {
                return generateRsaPrivateKey();
            } else {
                byte[] buffer = privateKeyValue.getBytes(StandardCharsets.UTF_8);
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
                KeyFactory keyFactory = KeyFactory.getInstance(RSA);
                return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
            }
        } catch (Exception e) {
            return null;
        }
    }

    private RSAPrivateKey generateRsaPrivateKey() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(RSA);
        generator.initialize(2048);
        return (RSAPrivateKey) generator.generateKeyPair().getPrivate();
    }

    private RSAPublicKey rsaPublicKey(RSAPrivateKey rsaPrivateKey) {
        RSAPrivateCrtKey privk = (RSAPrivateCrtKey) rsaPrivateKey;
        RSAPublicKeySpec publicKeySpec = new java.security.spec.RSAPublicKeySpec(privk.getModulus(), privk.getPublicExponent());

        try {
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            return (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
        } catch (Exception e) {
            return null;
        }
    }

}
