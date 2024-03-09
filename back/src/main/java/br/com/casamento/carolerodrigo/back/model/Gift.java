package br.com.casamento.carolerodrigo.back.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Gift {

    @Id
    UUID id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "present")
    Present present;
    String name;
    String message;
    String mercado_pago_preference;
    long mercado_pago_id_payment;
    String status;


}
