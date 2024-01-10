package br.com.casamento.carolerodrigo.back.controller;

import br.com.casamento.carolerodrigo.back.dto.AuthRequest;
import br.com.casamento.carolerodrigo.back.dto.AuthResponse;
import br.com.casamento.carolerodrigo.back.repository.LoginRepository;
import br.com.casamento.carolerodrigo.back.service.HashService;
import br.com.casamento.carolerodrigo.back.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final HashService hashService;

    private final LoginRepository loginRepository;
    private final JWTService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        var hashedPassword = hashService.hashPassword(request.password);
        var login = loginRepository.findLogin(request.login, hashedPassword);
        if (login == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        } else {
            return ResponseEntity.ok(AuthResponse.builder()
                    .token(jwtService.generateToken(login))
                    .build());
        }
    }

}
