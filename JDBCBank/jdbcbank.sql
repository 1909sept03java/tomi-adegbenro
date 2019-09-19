/*******************************************************************************
   JDBCBank Database - Version 1.4
   Script:jdbcbank.sql
   Description: database.
   DB Server: Oracle
   Author: Tomi Adegbenro
   
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER jdbcbank CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER jdbcbank
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to jdbcbank;
GRANT resource to jdbcbank;
GRANT create session TO jdbcbank;
GRANT create table TO jdbcbank;
GRANT create view TO jdbcbank;



conn jdbcbank/p4ssw0rd

DROP TABLE BankUser;
DROP TABLE BankAccount;
/

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE BankUser
(
    User_Id NUMBER NOT NULL,
    User_Name VARCHAR2(20) NOT NULL,
    pWord VARCHAR2(20) NOT NULL,
    Super_User NUMBER,
    CONSTRAINT PK_User PRIMARY KEY  (User_Id)
);

/*CREATE TABLE Account
(
    Account_Id NUMBER NOT NULL,
    Department_Name VARCHAR2(120),
    CONSTRAINT PK_Account PRIMARY KEY  (Account_Id)
);
*/

--FOREIGN KEY CONSTRAINTS 

/*ALTER TABLE Employees
ADD CONSTRAINT FK_DEPARTMENT_ID
FOREIGN KEY (Department_Id) REFERENCES Departments(Department_Id);
/
*/
--SET UP SEQUENCES TO PRODUCE PRIMARY KEYS 
CREATE SEQUENCE SQ_BankUser_PK
START WITH 1
INCREMENT BY 1;
/

/*CREATE SEQUENCE SQ_Account_PK
START WITH 100
INCREMENT BY 1;
/
*/

--TRIGGERS: CREATE "BEFORE" OR "AFTER TRIGGERS

CREATE OR REPLACE TRIGGER TR_INSERT_BankUser
BEFORE INSERT ON BankUser --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_BankUser_PK.NEXTVAL INTO :NEW.User_Id FROM DUAL;
END;
/

--INSERTING DUMMY DATA INTO USER TABLE
INSERT ALL
INTO BankUser (User_Name,pWord, Super_User)
VALUES('badegbenro','p4ss',0)
INTO BankUser (User_Name,pWord, Super_User)
VALUES('sheria','w0rd',0)
INTO BankUser (User_Name,pWord, Super_User)
VALUES('ebadamosi','p4ss',0)
SELECT * FROM DUAL; --DUAL IS A DUMMY TABLE, PLSQL USES IT TO MAKE STATEMENTS FIT QUERY FORMAT
