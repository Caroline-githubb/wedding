package br.com.casamento.carolerodrigo.back.repository.mock;

import br.com.casamento.carolerodrigo.back.model.Confirmation;
import br.com.casamento.carolerodrigo.back.repository.ConfirmationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public class MockConfirmationRepository implements ConfirmationRepository {

    @Override
    public void confirm(Confirmation confirmation) {

    }

    @Override
    public List<Confirmation> getAll() {
        return List.of(Confirmation.builder().build());
    }
}
