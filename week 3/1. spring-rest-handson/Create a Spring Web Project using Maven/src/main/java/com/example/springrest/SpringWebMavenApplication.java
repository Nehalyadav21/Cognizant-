package com.example.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Exercise 1: Create a Spring Web Project using Maven.
 *
 * Entry point for a minimal Spring Boot 3 web application, bootstrapped
 * with Maven, that exposes a single "hello" endpoint to confirm the
 * project is wired up correctly.
 */
@SpringBootApplication
public class SpringWebMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebMavenApplication.class, args);
    }
}
