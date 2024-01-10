package br.com.casamento.carolerodrigo.back.repository;

import br.com.casamento.carolerodrigo.back.model.Gift;

public interface GiftRepository {

    Gift[] findAllAvailable();

}
