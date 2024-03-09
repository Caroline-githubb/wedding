package br.com.casamento.carolerodrigo.back.repository;

import br.com.casamento.carolerodrigo.back.model.Gift;

import java.util.Optional;
import java.util.UUID;

public interface GiftRepository {

    Gift save(Gift gift);

    Optional<Gift> findByItem(UUID idItem);
}
