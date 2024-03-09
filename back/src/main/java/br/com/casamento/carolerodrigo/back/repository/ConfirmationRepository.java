package br.com.casamento.carolerodrigo.back.repository;

import br.com.casamento.carolerodrigo.back.model.Confirmation;

import java.util.List;

public interface ConfirmationRepository {

    void confirm(Confirmation confirmation);
    List<Confirmation> getAll();

}
