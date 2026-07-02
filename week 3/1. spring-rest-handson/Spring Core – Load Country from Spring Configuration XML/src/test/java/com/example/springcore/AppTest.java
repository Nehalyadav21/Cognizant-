package com.example.springcore;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {

    @Test
    void countryBeanLoadsFromXmlConfig() {
        try (ApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {

            Country country = context.getBean("country", Country.class);

            assertNotNull(country);
            assertEquals("IN", country.getCode());
            assertEquals("India", country.getName());
            assertEquals("New Delhi", country.getCapital());
        }
    }
}
