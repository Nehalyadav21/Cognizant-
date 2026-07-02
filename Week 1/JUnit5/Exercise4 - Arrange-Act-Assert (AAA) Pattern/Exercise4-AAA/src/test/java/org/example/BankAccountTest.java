package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100);
        System.out.println("Before Test: Account initialized with $100.");
    }

    @AfterEach
    void tearDown() {
        account = null;
        System.out.println("After Test: Cleaning up account object.");
    }

    @Test
    void testDeposit() {

        // Arrange
        double amount = 50;

        // Act
        account.deposit(amount);

        // Assert
        assertEquals(150, account.getBalance());
        System.out.println("Test: Deposit logic verified.");
    }
}