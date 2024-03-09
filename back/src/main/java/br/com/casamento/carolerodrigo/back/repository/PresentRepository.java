package br.com.casamento.carolerodrigo.back.repository;

import br.com.casamento.carolerodrigo.back.model.Present;

import java.util.List;

public interface PresentRepository {

    List<Present> findAllAvailable();

}
