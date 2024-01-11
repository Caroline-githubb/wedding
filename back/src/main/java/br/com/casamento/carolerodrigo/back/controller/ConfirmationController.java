package br.com.casamento.carolerodrigo.back.controller;

import br.com.casamento.carolerodrigo.back.dto.ConfirmationRequest;
import br.com.casamento.carolerodrigo.back.model.Confirmation;
import br.com.casamento.carolerodrigo.back.repository.ConfirmationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/confirmation")
@RequiredArgsConstructor
public class ConfirmationController {

    private final ModelMapper modelMapper;

    private final ConfirmationRepository confirmationRepository;

    @PostMapping("/confirm")
    public void confirm(@RequestBody ConfirmationRequest request) {
        Confirmation confirmation = modelMapper.map(request, Confirmation.class);
        this.confirmationRepository.confirm(confirmation);
    }

}
