package br.com.casamento.carolerodrigo.back.repository.mock;

import br.com.casamento.carolerodrigo.back.model.Present;
import br.com.casamento.carolerodrigo.back.repository.PresentRepository;
import org.springframework.stereotype.Repository;


@Repository
public class MockPresentRepository implements PresentRepository {
    @Override
    public Present[] findAllAvailable() {
        return new Present[] {
                Present.builder()
                        .name("fogao daco é bom")
                        .value(250.59)
                        .build(),
                Present.builder()
                        .name("panela velha")
                        .value(15.99)
                        .build(),
                Present.builder()
                        .name("passarinho que nao canta")
                        .value(5999.98)
                        .build()
        };
    }
}
