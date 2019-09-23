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
CREATE TABLE BANKUSER
(
    USER_ID NUMBER NOT NULL,
    USER_NAME VARCHAR2(20) NOT NULL,
    PASS VARCHAR2(20) NOT NULL,
    SUPER_USER NUMBER,
    CONSTRAINT PK_USER PRIMARY KEY  (User_Id)
);

CREATE TABLE BANKACCOUNT
(
    ACCOUNT_ID NUMBER NOT NULL,
    ACCOUNT_USER NUMBER NOT NULL,
    BALANCE NUMBER NOT NULL,
    F_BALANCE NUMBER,
    CONSTRAINT PK_ACCOUNT PRIMARY KEY  (Account_Id)
);

CREATE TABLE TRANSACTION_HISTORY
(
    TX_ID NUMBER NOT NULL,
    ACCT_ID NUMBER NOT NULL,
    LOGGED_AT TIMESTAMP NOT NULL,
    BALANCE NUMBER NOT NULL,
    F_BALANCE NUMBER,
    CONSTRAINT PK_TRANSACTIONS PRIMARY KEY  (TX_ID)
);
/
--FOREIGN KEY CONSTRAINTS 

/
ALTER TABLE BANKACCOUNT
ADD CONSTRAINT FK_ACCOUNT_OWNER
FOREIGN KEY (ACCOUNT_USER) REFERENCES BANKUSER(USER_ID);
--ON DELETE CASCADE;
/
ALTER TABLE TRANSACTION_HISTORY
ADD CONSTRAINT FK_TRANSACTIONS
FOREIGN KEY (ACCT_ID) REFERENCES BANKACCOUNT(ACCOUNT_ID);
/


--SET UP SEQUENCES TO PRODUCE PRIMARY KEYS 
CREATE SEQUENCE SQ_BANKUSER_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_BANKACCOUNT_PK
START WITH 100
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_TRANSACTION_PK
START WITH 1
INCREMENT BY 1;

--TRIGGERS: CREATE "BEFORE" OR "AFTER TRIGGERS

CREATE OR REPLACE TRIGGER TR_INSERT_BANKUSER
BEFORE INSERT ON BANKUSER --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_BANKUSER_PK.NEXTVAL INTO :NEW.User_Id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_BankAccount
BEFORE INSERT ON BANKACCOUNT --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_BANKACCOUNT_PK.NEXTVAL INTO :NEW.Account_Id FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TR_INSERT_TRANSACTIONS
BEFORE INSERT ON TRANSACTIONS --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_TRANSACTIONS_PK.NEXTVAL INTO :NEW.TX_ID FROM DUAL;
END;
/
--CREATE OR REPLACE TRIGGER TR_REGISTERED_TRANSACTIONS
--AFTER UPDATE ON BANKACCOUNT --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
--FOR EACH ROW
--BEGIN
--    SELECT SQ_TRANSACTIONS_PK.NEXTVAL INTO :NEW.TX_ID FROM DUAL;
--END;

--INSERTING DUMMY DATA INTO USER TABLE
INSERT ALL
INTO BANKUSER (USER_NAME,PASS, SUPER_USER)
VALUES('badegbenro','p4ss',0)
INTO BANKUSER (USER_NAME,PASS, SUPER_USER)
VALUES('sheria','w0rd',0)
INTO BANKUSER (USER_NAME,PASS, SUPER_USER)
VALUES('ebadamosi','p4ss',0)
SELECT * FROM DUAL; --DUAL IS A DUMMY TABLE, PLSQL USES IT TO MAKE STATEMENTS FIT QUERY FORMAT
/

--INSERTING DUMMY DATA INTO ACCOUNT TABLE
INSERT ALL
INTO BANKACCOUNT (ACCOUNT_USER, BALANCE, F_BALANCE)
VALUES(1, 450, 0)
INTO BANKACCOUNT (ACCOUNT_USER, BALANCE, F_BALANCE)
VALUES(2, 200, 0)
INTO BANKACCOUNT (ACCOUNT_USER, BALANCE, F_BALANCE)
VALUES(3, 0, 0)
SELECT * FROM DUAL; --DUAL IS A DUMMY TABLE, PLSQL USES IT TO MAKE STATEMENTS FIT QUERY FORMAT
/

--CREATING ADDITIONAL CONSTRIANTS
--FIRST CONFIRM BALANCE IS NOT LESS THAN ZERO
ALTER TABLE BANKACCOUNT ADD CONSTRAINT CK_BALANCE_NOT_ZERO
CHECK (BALANCE >=0);
ALTER TABLE BANKACCOUNT ADD CONSTRAINT CK_F_BALANCE_NOT_ZERO
CHECK (F_BALANCE >=0);
/
--STORED PROCEDURE TO DEPOSIT VALUE
CREATE OR REPLACE PROCEDURE SP_DEPOSIT_INTO_ACCOUNT(A_ID IN NUMBER, U_ID IN NUMBER, DEP IN NUMBER)
IS
--DECLARE VARIABLE
ACC_EXISTS INTEGER;
BEGIN
    SELECT COUNT(BANKACCOUNT.ACCOUNT_ID) INTO ACC_EXISTS FROM BANKACCOUNT  WHERE BANKACCOUNT.ACCOUNT_USER = U_ID AND BANKACCOUNT.ACCOUNT_ID = A_ID;
    IF ACC_EXISTS >0 THEN
        UPDATE BANKACCOUNT SET F_BALANCE = BALANCE WHERE  BANKACCOUNT.ACCOUNT_USER = U_ID AND BANKACCOUNT.ACCOUNT_ID = A_ID;
        UPDATE BANKACCOUNT SET BALANCE = BALANCE+DEP WHERE BANKACCOUNT.ACCOUNT_USER = U_ID AND BANKACCOUNT.ACCOUNT_ID = A_ID;
    END IF;
    COMMIT;
    --EXCEPTION HANDLING
    EXCEPTION
        WHEN OTHERS THEN
        ROLLBACK;
END;
/

CREATE OR REPLACE PROCEDURE SP_WITHDRAW_INTO_ACCOUNT(A_ID IN NUMBER, U_ID IN NUMBER, WD IN NUMBER)
IS
--DECLARE VARIABLE
ACC_EXISTS INTEGER;
BEGIN
    SELECT COUNT(BANKACCOUNT.ACCOUNT_ID) INTO ACC_EXISTS FROM BANKACCOUNT  WHERE BANKACCOUNT.ACCOUNT_USER = U_ID AND BANKACCOUNT.ACCOUNT_ID = A_ID;
    IF ACC_EXISTS >0 THEN
        UPDATE BANKACCOUNT SET F_BALANCE = BALANCE WHERE  BANKACCOUNT.ACCOUNT_USER = U_ID AND BANKACCOUNT.ACCOUNT_ID = A_ID;
        UPDATE BANKACCOUNT SET BALANCE = BALANCE-WD WHERE BANKACCOUNT.ACCOUNT_USER = U_ID AND BANKACCOUNT.ACCOUNT_ID = A_ID;
    END IF;
    COMMIT;
    --EXCEPTION HANDLING
    EXCEPTION
        WHEN OTHERS THEN
        ROLLBACK;
END;
/

CREATE OR REPLACE PROCEDURE SP_CREATE_NEW_ACCOUNT(U_ID IN NUMBER)
IS
--DECLARE VARIABLE
ACC_EXISTS INTEGER;
BEGIN
    INSERT INTO BANKACCOUNT (ACCOUNT_USER, BALANCE, F_BALANCE) VALUES (U_ID, 0, 0);
    COMMIT;
    --EXCEPTION HANDLING
    EXCEPTION
        WHEN OTHERS THEN
        ROLLBACK;
END;
/

CREATE OR REPLACE PROCEDURE SP_DELETE_MY_ACCOUNT(U_ID IN NUMBER, A_ID IN NUMBER)
IS
--DECLARE VARIABLE
ACC_VALID INTEGER;
BEGIN
    SELECT COUNT(BANKACCOUNT.ACCOUNT_ID) INTO ACC_VALID FROM BANKACCOUNT  WHERE BANKACCOUNT.ACCOUNT_USER = U_ID AND BANKACCOUNT.ACCOUNT_ID = A_ID;
    IF ACC_VALID = 1 THEN
        DELETE FROM BANKACCOUNT WHERE BANKACCOUNT.ACCOUNT_USER = U_ID AND BANKACCOUNT.ACCOUNT_ID = A_ID;
    END IF;
    COMMIT;
    --EXCEPTION HANDLING
    EXCEPTION
        WHEN OTHERS THEN
        ROLLBACK;
END;
/

CREATE OR REPLACE PROCEDURE SP_CREATE_NEW_USER(U_NAME IN VARCHAR2, PWD IN VARCHAR2, USER_CREATED OUT NUMBER)
IS
--DECLARE VARIABLE
USER_CHECK NUMBER;
BEGIN
    SELECT count(USER_NAME) INTO USER_CHECK FROM BANKUSER WHERE BANKUSER.USER_NAME = U_NAME;
    IF USER_CHECK = 0 THEN
    INSERT INTO BANKUSER (USER_NAME, PASS, SUPER_USER) VALUES (U_NAME, PWD, 0);
    USER_CREATED := 0;
    END IF;
    COMMIT;
    --EXCEPTION HANDLING
    EXCEPTION
        WHEN OTHERS THEN
        ROLLBACK;
END;
/

/
CREATE OR REPLACE PROCEDURE SP_DELETE_USER(U_ID IN NUMBER)
IS
--DECLARE VARIABLE
USR_VALID INTEGER;
BEGIN
    SELECT COUNT(BANKUSER.USER_ID) INTO USR_VALID FROM BANKUSER  WHERE BANKUSER.USER_ID = U_ID;
    IF USR_VALID = 1 THEN
        DELETE FROM BANKUSER WHERE BANKUSER.USER_ID = U_ID;
    END IF;
    COMMIT;
    --EXCEPTION HANDLING
    EXCEPTION
        WHEN OTHERS THEN
        ROLLBACK;
END;
/
DECLARE
UID NUMBER;
BEGIN
    UID := 10;
    SP_DELETE_USER(UID);
    DBMS_OUTPUT.PUT_LINE('ACCOUNT EXIST VALUE: '||UID);
END;
/
--commit;
--INSERT INTO BANKUSER (USER_NAME, PASS, SUPER_USER) VALUES ("john", "oracle", 0);
/
--troubleshooting
--DECLARE
--DEPT_ACC NUMBER;
--BEGIN
--SP_DEPOSIT_INTO_ACCOUNT(100,1, 47);
--DBMS_OUTPUT.PUT_LINE('AMOUNT UPDATE IN ACCOUNT: '||ACCOUNT_ID||' IS'||ACCOUNT_USER||' IS '||);
--END; 
/
--delete from bankaccount where BANKACCOUNT.ACCOUNT_USER = 1 AND BANKACCOUNT.ACCOUNT_ID = 107;
/
--ALTER TABLE BankAccount
--DROP CONSTRAINT FK_ACCOUNT_OWNER;
/    


--select * from BANKACCOUNT where ACCOUNT_USER = 1 and account_id = 100;
select * from BANKUSER;
/
update BANKUSER set SUPER_USER = 1 where USER_ID = 2;
/
commit;