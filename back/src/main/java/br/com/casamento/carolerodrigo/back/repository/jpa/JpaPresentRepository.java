package br.com.casamento.carolerodrigo.back.repository.jpa;

import br.com.casamento.carolerodrigo.back.model.Present;
import br.com.casamento.carolerodrigo.back.repository.PresentRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@org.springframework.stereotype.Repository
public class JpaPresentRepository implements Repository<Present, UUID>, PresentRepository {

    private final EntityManager entityManager;

    @Override
    public List<Present> findAllAvailable() {
        return entityManager
                .createQuery("Select p from Present p", Present.class)
                .getResultList();
    }
}
