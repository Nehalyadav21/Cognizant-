# Spring Data JPA - Quick Example

A minimal Spring Boot 3 project showing how little code Spring Data JPA
needs to give you full CRUD + query support for an entity.

## What's here
- `Country.java` — a plain `@Entity` with `code` as its `@Id`.
- `CountryRepository.java` — just an interface extending `JpaRepository<Country, String>`.
  No implementation needed; Spring Data JPA generates it at runtime, including
  the derived query method `findByName(String name)`.
- `DataLoader.java` — a `CommandLineRunner` that seeds a few countries and
  prints the results of `findAll()`, `findById()`, and the derived query, so
  you can see it working the moment you run the app.
- Uses an in-memory **H2** database, so it runs with zero setup.

## Run it

```bash
mvn spring-boot:run
```

Or run `QuickExampleApplication`'s `main` method from IntelliJ. Watch the
console output for the printed `Country` records.

Browse the database directly at `http://localhost:8080/h2-console`
(JDBC URL: `jdbc:h2:mem:quickexampledb`, user: `sa`, no password).

## Run tests

```bash
mvn test
```
