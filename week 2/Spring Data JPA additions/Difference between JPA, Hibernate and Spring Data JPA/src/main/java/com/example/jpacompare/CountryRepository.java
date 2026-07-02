package com.example.jpacompare;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA is a FRAMEWORK built on top of JPA that removes almost
 * all boilerplate. It generates the implementation of this interface at
 * runtime — no EntityManager or Session code required from us at all.
 *
 * It still uses Hibernate as the JPA provider underneath, and JPA as the
 * specification underneath that — this is just a higher, more productive
 * layer on top of both.
 */
public interface CountryRepository extends JpaRepository<Country, String> {
}
