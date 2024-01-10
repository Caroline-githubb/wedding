package br.com.casamento.carolerodrigo.back.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Login {

    private String login;
    private String hashedPassword;

}
