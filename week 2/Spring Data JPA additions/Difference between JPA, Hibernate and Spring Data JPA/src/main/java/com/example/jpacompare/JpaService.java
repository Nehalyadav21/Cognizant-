package com.example.jpacompare;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * JPA (Jakarta Persistence API) is a SPECIFICATION — a set of interfaces
 * (EntityManager, EntityManagerFactory, etc.) defining how Java objects
 * should be persisted. It does not do the persisting itself; it needs a
 * provider (Hibernate, EclipseLink, ...) underneath.
 *
 * This service talks only to the standard jakarta.persistence.EntityManager
 * API — no Hibernate- or Spring-specific classes at all.
 */
@Service
public class JpaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Country country) {
        entityManager.persist(country);
    }

    public Country findByCode(String code) {
        return entityManager.find(Country.class, code);
    }

    public java.util.List<Country> findAll() {
        return entityManager
                .createQuery("SELECT c FROM Country c", Country.class)
                .getResultList();
    }
}
