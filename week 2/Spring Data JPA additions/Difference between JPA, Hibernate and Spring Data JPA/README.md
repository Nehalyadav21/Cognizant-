# Difference between JPA, Hibernate and Spring Data JPA

These three terms get used almost interchangeably, but they sit at three
different layers, each built on top of the one before it.

```
Spring Data JPA   ──►  a framework that generates repository code for you
        │
        ▼
   Hibernate       ──►  a JPA provider — the actual implementation
        │
        ▼
      JPA          ──►  a specification — just interfaces, no implementation
```

## JPA (Jakarta Persistence API)
- A **specification**, not a library you can run on its own. It defines
  interfaces like `EntityManager`, `EntityManagerFactory`, and annotations
  like `@Entity`, `@Id`, `@Table`.
- It describes *how* Java objects should be mapped to relational tables and
  persisted, but provides no implementation itself.
- You always need a **provider** underneath to actually do the work.

## Hibernate
- One of several **implementations (providers)** of the JPA specification
  — others include EclipseLink and OpenJPA.
- Spring Boot uses Hibernate as its default JPA provider.
- Hibernate implements everything JPA requires, but also exposes its own
  **extra, non-JPA API** (`org.hibernate.Session`, HQL specifics, caching
  controls, custom types) that goes beyond the JPA spec.
- You can use Hibernate directly without JPA (its native API predates JPA),
  though in a Spring Boot app you'd rarely need to.

## Spring Data JPA
- A **framework built on top of JPA** (and therefore, in practice, on top
  of Hibernate) that eliminates repository boilerplate.
- You write an interface (e.g. `interface CountryRepository extends
  JpaRepository<Country, String>`) and Spring Data JPA generates the
  implementation — `save`, `findById`, `findAll`, `delete`, plus derived
  query methods like `findByName(...)` — at runtime.
- It does not replace JPA/Hibernate; it sits on top of them and uses an
  `EntityManager` internally, the same one JPA defines.

## Side-by-side comparison

| | JPA | Hibernate | Spring Data JPA |
|---|---|---|---|
| **What it is** | Specification (interfaces only) | Implementation (a JPA provider) | Framework on top of JPA |
| **Can run alone?** | No — needs a provider | Yes — has its own native API too | No — needs JPA + a provider underneath |
| **Boilerplate for CRUD** | You write `EntityManager` calls yourself | You write `Session` calls yourself | Almost none — extend an interface |
| **Vendor lock-in** | None — spec is provider-agnostic | Some, if you use Hibernate-only APIs | None beyond standard JPA usage |
| **Typical use in Spring Boot** | Used indirectly via `EntityManager` when needed | Used automatically underneath | The default, recommended day-to-day API |

## See it in code

This project implements the **exact same operation** — save a `Country`
and read it back — three ways, so the difference is concrete rather than
just theoretical:

- `JpaService.java` — uses only the standard `jakarta.persistence.EntityManager` API.
- `HibernateService.java` — unwraps the `EntityManager` to get Hibernate's
  native `Session` and uses that directly.
- `CountryRepository.java` — a one-line Spring Data JPA interface; no
  implementation code at all.

`ComparisonRunner.java` calls all three on startup and prints the results,
so you can see identical outcomes from very different amounts of code.

## Run it

```bash
mvn spring-boot:run
```

Watch the console output — it's grouped into three sections, one per approach.

## Run tests

```bash
mvn test
```
