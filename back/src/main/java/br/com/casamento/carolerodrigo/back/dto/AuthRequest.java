package br.com.casamento.carolerodrigo.back.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRequest {

    @NotBlank
    public String login;
    @NotBlank
    public String password;

}
