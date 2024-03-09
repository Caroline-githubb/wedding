package br.com.casamento.carolerodrigo.back.repository.jpa;

import br.com.casamento.carolerodrigo.back.model.Confirmation;
import br.com.casamento.carolerodrigo.back.repository.ConfirmationRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@org.springframework.stereotype.Repository
public class JpaConfirmationRepository implements Repository<Confirmation, UUID>, ConfirmationRepository {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void confirm(Confirmation confirmation) {
        entityManager.persist(confirmation);

        confirmation.getAdultsNames().stream().forEach(x -> x.setParentId(confirmation.getId()));
        confirmation.getAdultsNames().stream().forEach(entityManager::persist);

        confirmation.getChildrenNames().stream().forEach(x -> x.setParentId(confirmation.getId()));
        confirmation.getChildrenNames().stream().forEach(entityManager::persist);
    }

    @Override
    public List<Confirmation> getAll() {
        return entityManager
                .createQuery("Select c from Confirmation c", Confirmation.class)
                .getResultList();
    }
}
