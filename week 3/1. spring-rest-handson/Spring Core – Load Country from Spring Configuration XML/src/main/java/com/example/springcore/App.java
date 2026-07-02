package com.example.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Loads the Spring XML configuration file (applicationContext.xml) and
 * retrieves the "country" bean defined there, demonstrating classic
 * XML-based Spring configuration alongside Spring Boot.
 */
public class App {

    public static void main(String[] args) {
        try (ApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {

            Country country = context.getBean("country", Country.class);
            System.out.println("Loaded bean from XML configuration:");
            System.out.println(country);
        }
    }
}
