package br.com.casamento.carolerodrigo.back.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Gift {

    UUID id;
    Present present;
    String name;
    String message;
    String mercado_pago_preference;
    String status;


}
