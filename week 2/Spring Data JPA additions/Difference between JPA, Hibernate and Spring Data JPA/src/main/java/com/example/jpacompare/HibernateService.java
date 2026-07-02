package com.example.jpacompare;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

/**
 * Hibernate is the JPA PROVIDER used underneath by default in Spring Boot.
 * It implements the JPA specification, but it also exposes its own richer,
 * Hibernate-specific API (org.hibernate.Session) that goes beyond what JPA
 * defines — e.g. HQL specifics, second-level cache controls, custom types.
 *
 * This service unwraps the standard EntityManager to get at the native
 * Hibernate Session, and uses Hibernate's own API directly.
 */
@Service
public class HibernateService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Country country) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(country);
    }

    public Country findByCode(String code) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Country.class, code);
    }

    public java.util.List<Country> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Country> query = session.createQuery("FROM Country", Country.class);
        return query.list();
    }
}
