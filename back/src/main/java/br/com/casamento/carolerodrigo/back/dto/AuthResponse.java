package br.com.casamento.carolerodrigo.back.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponse {

    private String token;

}
