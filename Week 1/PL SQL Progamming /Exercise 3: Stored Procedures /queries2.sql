-- ===========================================
-- STORED PROCEDURES ASSIGNMENT
-- ===========================================

-- Drop tables if they already exist
DROP TABLE Accounts;
DROP TABLE Employees;

-- ===========================================
-- Create Accounts Table
-- ===========================================

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    AccountType VARCHAR2(20),
    Balance NUMBER(10,2)
);

-- ===========================================
-- Create Employees Table
-- ===========================================

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(50),
    Department VARCHAR2(30),
    Salary NUMBER(10,2)
);

-- ===========================================
-- Insert Sample Data
-- ===========================================

INSERT INTO Accounts VALUES (101,'Nehal','Savings',10000);
INSERT INTO Accounts VALUES (102,'Rahul','Savings',15000);
INSERT INTO Accounts VALUES (103,'Priya','Current',20000);
INSERT INTO Accounts VALUES (104,'Amit','Savings',12000);

INSERT INTO Employees VALUES (1,'Rohit','IT',50000);
INSERT INTO Employees VALUES (2,'Sneha','HR',45000);
INSERT INTO Employees VALUES (3,'Karan','IT',60000);
INSERT INTO Employees VALUES (4,'Anjali','Finance',55000);

COMMIT;

-- ===========================================
-- Scenario 1
-- Process Monthly Interest (1%)
-- ===========================================

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/

-- Execute Procedure
BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM Accounts;

-- ===========================================
-- Scenario 2
-- Update Employee Bonus
-- ===========================================

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_Department IN VARCHAR2,
    p_BonusPercent IN NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');
END;
/

-- Execute Procedure
BEGIN
    UpdateEmployeeBonus('IT',10);
END;
/

SELECT * FROM Employees;

-- ===========================================
-- Scenario 3
-- Transfer Funds Between Accounts
-- ===========================================

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccount IN NUMBER,
    p_ToAccount IN NUMBER,
    p_Amount IN NUMBER
)
AS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    IF v_Balance >= p_Amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund transfer successful.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');

    END IF;
END;
/

-- Execute Procedure
BEGIN
    TransferFunds(101,102,2000);
END;
/

SELECT * FROM Accounts;