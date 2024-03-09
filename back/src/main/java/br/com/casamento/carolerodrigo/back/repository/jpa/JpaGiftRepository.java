package br.com.casamento.carolerodrigo.back.repository.jpa;

import br.com.casamento.carolerodrigo.back.model.Gift;
import br.com.casamento.carolerodrigo.back.repository.GiftRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@org.springframework.stereotype.Repository
public class JpaGiftRepository implements Repository<Gift, UUID>, GiftRepository {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Gift save(Gift gift) {
        this.entityManager.persist(gift);
        return gift;
    }

    @Override
    public Optional<Gift> findByItem(UUID idItem) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Gift> q = cb.createQuery(Gift.class);
        Root<Gift> c = q.from(Gift.class);
        q.select(c);

        q.where(
                cb.equal(c.get("id"), idItem)
        );

        return entityManager.createQuery(q).getResultList().stream().findAny();
    }
}
