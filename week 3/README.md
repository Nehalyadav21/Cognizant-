# Week 3 — Spring REST using Spring Boot 3

Each subfolder below is a standalone Maven project (built with Spring Boot 3.2.5,
Java 17) that you can open directly in IntelliJ IDEA as a Maven project
(`File > Open`, point at the folder containing `pom.xml`). This mirrors the
project layout used in the Week 2 repo (e.g. `librarymanagement`).

## Structure

```
Week 3/
├── 1. spring-rest-handson/
│   ├── Create a Spring Web Project using Maven/
│   └── Spring Core – Load Country from Spring Configuration XML/
├── 2. spring-rest-handson/
│   ├── Hello World RESTful Web Service/
│   ├── REST - Country Web Service/
│   └── REST - Get country based on country code/
├── 3. spring-rest-handson/
│   └── All hands-on/
└── 5. JWT-handson/
    └── Create authentication service that returns JWT/
```

## Exercise notes

| Folder | What it does |
|---|---|
| **1. spring-rest-handson / Create a Spring Web Project using Maven** | Minimal Spring Boot 3 web project bootstrapped with Maven; single `/` endpoint to confirm the setup works. |
| **1. spring-rest-handson / Spring Core – Load Country from Spring Configuration XML** | Demonstrates classic Spring XML configuration (`applicationContext.xml`) defining a `Country` bean, loaded via `ClassPathXmlApplicationContext`. |
| **2. spring-rest-handson / Hello World RESTful Web Service** | `@RestController` exposing `GET /hello` returning `"Hello World!"`. |
| **2. spring-rest-handson / REST - Country Web Service** | Full CRUD REST API for `Country` (`GET/POST/PUT/DELETE /api/countries`) backed by an in-memory store. |
| **2. spring-rest-handson / REST - Get country based on country code** | Focused single-endpoint service: `GET /api/countries/{code}`. |
| **3. spring-rest-handson / All hands-on** | Combined project bringing together hello-world + full Country CRUD in one app. |
| **5. JWT-handson / Create authentication service that returns JWT** | `POST /api/auth/login` validates credentials (demo user: `demo` / `password`) via Spring Security and returns a signed JWT (JJWT 0.12.5). |

## Running any project

```bash
cd "<project folder>"
mvn spring-boot:run
```

or just run the `*Application` class's `main` method directly from IntelliJ.

## Running tests

```bash
mvn test
```

> Note: exercise titles and groupings were pulled from
> `DN_-_Java_FSE_Mandatory_hands-on_detail.xlsx` (sheet: Java FSE, skill:
> "Spring REST using Spring Boot 3"). Code inside each project is a working
> starting point for the exercise — extend it as needed to match your
> instructor's exact requirements.
