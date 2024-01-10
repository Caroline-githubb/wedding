package br.com.casamento.carolerodrigo.back.controller;

import br.com.casamento.carolerodrigo.back.config.JWTConfig;
import br.com.casamento.carolerodrigo.back.dto.AuthRequest;
import br.com.casamento.carolerodrigo.back.repository.LoginRepository;
import br.com.casamento.carolerodrigo.back.repository.mock.MockLoginRepository;
import br.com.casamento.carolerodrigo.back.service.HashService;
import br.com.casamento.carolerodrigo.back.service.JWTService;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {

    private final HashService hashService = new HashService();
    private final LoginRepository loginRepository = new MockLoginRepository(hashService);
    private final Algorithm algorithm = new JWTConfig().algorithm();
    private final JWTService jwtService = new JWTService(algorithm);
    private final AuthController authController = new AuthController(hashService, loginRepository, jwtService);

    @Test
    public void shouldAuthorize() {
        AuthRequest authRequest = AuthRequest.builder()
                .login("teste")
                .password("senha123")
                .build();

        var response = authController.login(authRequest);

        assertNotNull(response.getBody());
        assertFalse(StringUtils.isEmpty(response.getBody().getToken()));
    }

}