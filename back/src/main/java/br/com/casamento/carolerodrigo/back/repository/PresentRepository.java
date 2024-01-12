package br.com.casamento.carolerodrigo.back.repository;

import br.com.casamento.carolerodrigo.back.model.Present;

public interface PresentRepository {

    Present[] findAllAvailable();

}
