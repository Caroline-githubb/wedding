package br.com.casamento.carolerodrigo.back.service;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class HashService {

    public String hashPassword(String password) {
        try {
            return new String(hash(password));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private byte[] hash(String originalString) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(
                originalString.getBytes(StandardCharsets.UTF_8));
    }

}
