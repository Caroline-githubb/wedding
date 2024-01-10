package br.com.casamento.carolerodrigo.back.service;

import br.com.casamento.carolerodrigo.back.model.Login;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTService {

    private final Algorithm algorithm;

    public String generateToken(Login login) {
        Instant iat = Instant.now();
        return JWT.create()
                .withIssuer("casamentos")
                .withClaim("name", login.getLogin())
                .withIssuedAt(iat)
                .withExpiresAt(iat.plus(1, ChronoUnit.HOURS))
                .sign(algorithm);
    }

}
