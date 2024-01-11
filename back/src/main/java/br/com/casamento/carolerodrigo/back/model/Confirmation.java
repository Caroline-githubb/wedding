package br.com.casamento.carolerodrigo.back.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Confirmation {

    public String fullName;
    public boolean answer;
    public String email;
    public String phone;
    public String obs;
    public Confirmation[] adultsNames;
    public Confirmation[] childrenNames;

}
