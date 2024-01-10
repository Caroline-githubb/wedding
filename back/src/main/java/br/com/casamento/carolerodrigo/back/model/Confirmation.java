package br.com.casamento.carolerodrigo.back.model;

import lombok.Data;

@Data
public class Confirmation {

    public String fullName;
    public boolean answer;
    public int adultQuantity;
    public int childQuantity;
    public String email;
    public String phone;
    public String obs;
    public String[] adultsNames;
    public String[] childrenNames;

}
