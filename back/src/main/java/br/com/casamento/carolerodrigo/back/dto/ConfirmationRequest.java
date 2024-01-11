package br.com.casamento.carolerodrigo.back.dto;

import lombok.Data;

@Data
public class ConfirmationRequest {

    public String fullName;
    public boolean answer;
    public String email;
    public String phone;
    public String obs;
    public String[] adultsNames;
    public String[] childrenNames;

}
