package br.com.casamento.carolerodrigo.back.controller;

import br.com.casamento.carolerodrigo.back.dto.AuthRequest;
import br.com.casamento.carolerodrigo.back.dto.AuthResponse;
import br.com.casamento.carolerodrigo.back.model.Confirmation;
import br.com.casamento.carolerodrigo.back.repository.ConfirmationRepository;
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
@RequestMapping("/confirmation")
@RequiredArgsConstructor
public class ConfirmationController {

    private final ConfirmationRepository confirmationRepository;

    @PostMapping("/confirm")
    public void confirm(@RequestBody Confirmation request) {
        confirmationRepository.confirm(request);
    }

}
