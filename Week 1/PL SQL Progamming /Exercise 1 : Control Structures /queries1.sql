-- ============================================
-- BANK MANAGEMENT SYSTEM - PL/SQL ASSIGNMENT
-- ============================================

-- Drop tables if they already exist
DROP TABLE Loans;
DROP TABLE Customers;

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER(10,2),
    IsVIP VARCHAR2(5)
);

-- ============================================
-- Create Loans Table
-- ============================================

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER(5,2),
    DueDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- ============================================
-- Insert Sample Data into Customers
-- ============================================

INSERT INTO Customers VALUES (101,'Nehal',21,12000,'FALSE');
INSERT INTO Customers VALUES (102,'Rahul',65,15000,'FALSE');
INSERT INTO Customers VALUES (103,'Priya',70,8000,'FALSE');
INSERT INTO Customers VALUES (104,'Amit',45,25000,'FALSE');
INSERT INTO Customers VALUES (105,'Sneha',62,5000,'FALSE');

-- ============================================
-- Insert Sample Data into Loans
-- ============================================

INSERT INTO Loans VALUES (201,101,9.50,SYSDATE+40);
INSERT INTO Loans VALUES (202,102,10.50,SYSDATE+20);
INSERT INTO Loans VALUES (203,103,11.00,SYSDATE+15);
INSERT INTO Loans VALUES (204,104,9.00,SYSDATE+60);
INSERT INTO Loans VALUES (205,105,10.00,SYSDATE+10);

COMMIT;

-- ============================================
-- Scenario 1
-- Apply 1% discount for customers above 60
-- ============================================

BEGIN
    FOR rec IN (
        SELECT l.LoanID
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');
END;
/

-- ============================================
-- Display Updated Loan Details
-- ============================================

SELECT * FROM Loans;

-- ============================================
-- Scenario 2
-- Promote customers with balance >10000 to VIP
-- ============================================

BEGIN
    FOR rec IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');
END;
/

-- ============================================
-- Display Updated Customer Details
-- ============================================

SELECT * FROM Customers;

-- ============================================
-- Scenario 3
-- Print reminders for loans due within 30 days
-- ============================================

BEGIN
    FOR rec IN (
        SELECT c.Name,
               l.LoanID,
               l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || rec.Name ||
            ', your Loan ID ' || rec.LoanID ||
            ' is due on ' ||
            TO_CHAR(rec.DueDate,'DD-MON-YYYY')
        );
    END LOOP;
END;
/