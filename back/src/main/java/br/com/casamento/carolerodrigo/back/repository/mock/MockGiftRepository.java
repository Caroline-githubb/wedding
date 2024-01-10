package br.com.casamento.carolerodrigo.back.repository.mock;

import br.com.casamento.carolerodrigo.back.model.Gift;
import br.com.casamento.carolerodrigo.back.repository.GiftRepository;
import org.springframework.stereotype.Repository;


@Repository
public class MockGiftRepository implements GiftRepository {
    @Override
    public Gift[] findAllAvailable() {
        return new Gift[] {
                Gift.builder()
                        .name("fogao daco é bom")
                        .value(250.59)
                        .build(),
                Gift.builder()
                        .name("panela velha")
                        .value(15.99)
                        .build(),
                Gift.builder()
                        .name("passarinho que nao canta")
                        .value(5999.98)
                        .build()
        };
    }
}
