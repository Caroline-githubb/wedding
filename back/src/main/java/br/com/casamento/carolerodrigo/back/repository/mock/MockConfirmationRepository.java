package br.com.casamento.carolerodrigo.back.repository.mock;

import br.com.casamento.carolerodrigo.back.model.Confirmation;
import br.com.casamento.carolerodrigo.back.repository.ConfirmationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MockConfirmationRepository implements ConfirmationRepository {

    @Override
    public void confirm(Confirmation confirmation) {

    }
}
