package br.com.casamento.carolerodrigo.back.repository.mock;

import br.com.casamento.carolerodrigo.back.model.Gift;
import br.com.casamento.carolerodrigo.back.repository.GiftRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


public class MockGiftRepository implements GiftRepository {

    @Override
    public Gift save(Gift gift) {
        return gift;
    }

    @Override
    public Optional<Gift> findByItem(UUID idItem) {
        return Optional.empty();
    }
}
