/*******************************************************************************
   Revature Employee Reimbursement System Database - Version 1.4
   Script:revers.sql
   Description: database.
   DB Server: Oracle
   Author: Tomi Adegbenro
   
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER revers CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER revers
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to revers;
GRANT resource to revers;
GRANT create session TO revers;
GRANT create table TO revers;
GRANT create view TO revers;



conn revers/p4ssw0rd

DROP TABLE EMPLOYEE CASCADE CONSTRAINTS;
DROP TABLE REQUEST CASCADE CONSTRAINTS;
DROP TABLE RECEIPT CASCADE CONSTRAINTS;
DROP TABLE CREDENTIALS CASCADE CONSTRAINTS;
/

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE EMPLOYEE
(
    EMP_ID NUMBER NOT NULL,
    F_NAME VARCHAR2(20) NOT NULL,
    L_NAME VARCHAR2(20) NOT NULL,
    MGR NUMBER NOT NULL,
    M_ROLE NUMBER,
    CONSTRAINT PK_EMP PRIMARY KEY  (EMP_ID)
);

CREATE TABLE CREDENTIALS
(
    CRED_ID NUMBER NOT NULL,
    UNAME VARCHAR2(20) NOT NULL,
    PASS VARCHAR2(20) NOT NULL,
    EMP_NUM NUMBER NOT NULL,
    CONSTRAINT PK_CRED PRIMARY KEY  (CRED_ID)
);

CREATE TABLE REQUEST
(
    REQ_ID NUMBER NOT NULL,
    TITLE VARCHAR2(20) NOT NULL,
    SUMMARY VARCHAR2(20), 
    REQ_EMP NUMBER NOT NULL,
    AMOUNT NUMBER NOT NULL,
    REQ_DATE DATE,
    STATUS NUMBER,
    STATUS_DATE DATE,
    CONSTRAINT PK_REQUEST PRIMARY KEY  (REQ_ID)
);

CREATE TABLE RECEIPT
(
    RCT_ID NUMBER NOT NULL,
    REQ_NUM NUMBER NOT NULL,
    --IMG BLOB,
    CONSTRAINT PK_RECEIPT PRIMARY KEY  (RCT_ID)
);
/

--FOREIGN KEY CONSTRAINTS 
ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_MANAGER
FOREIGN KEY (MGR) REFERENCES EMPLOYEE(EMP_ID)
ON DELETE CASCADE;
/
ALTER TABLE REQUEST
ADD CONSTRAINT FK_REQ_EMP
FOREIGN KEY (REQ_EMP) REFERENCES EMPLOYEE(EMP_ID)
ON DELETE CASCADE;
/
ALTER TABLE RECEIPT
ADD CONSTRAINT FK_REQ_ID
FOREIGN KEY (REQ_NUM) REFERENCES REQUEST(REQ_ID)
ON DELETE CASCADE;
/
ALTER TABLE CREDENTIALS
ADD CONSTRAINT FK_CRED_ID
FOREIGN KEY (EMP_NUM) REFERENCES EMPLOYEE(EMP_ID)
ON DELETE CASCADE;

--INSERTING DUMMY DATA INTO EMPLOYEE
INSERT ALL
INTO EMPLOYEE (EMP_ID, F_NAME, L_NAME, MGR, M_ROLE)
VALUES(1, 'Julius', 'Caesar', 2, 0)
INTO EMPLOYEE (EMP_ID, F_NAME, L_NAME, MGR, M_ROLE)
VALUES(2, 'Augustus', 'Caesar', 2, 1)
SELECT * FROM DUAL;
/

--INSERTING DUMMY DATA INTO CREDENTIALS
INSERT ALL
INTO CREDENTIALS (CRED_ID, UNAME, PASS, EMP_NUM)
VALUES(1, 'jcaesar', 'p4ss', 1)
INTO CREDENTIALS (CRED_ID, UNAME, PASS, EMP_NUM)
VALUES(2, 'acaesar', 'word', 2)
SELECT * FROM DUAL;
/
--INSERTING DUMMY DATA INTO REQUEST
INSERT ALL
INTO REQUEST (REQ_ID, TITLE, SUMMARY, REQ_EMP, AMOUNT, REQ_DATE, STATUS, STATUS_DATE)
VALUES(1, 'Cabo Convention', 'Went to Cabo', 1, 450,TO_DATE('2019-01-08', 'yyyy-mm-dd'), 1, TO_DATE('2019-01-11', 'yyyy-mm-dd'))
INTO REQUEST (REQ_ID, TITLE, SUMMARY, REQ_EMP, AMOUNT, REQ_DATE, STATUS, STATUS_DATE)
VALUES(2, 'Sales Pitch', 'Pitched to Acme', 1, 40,TO_DATE('2019-09-18', 'yyyy-mm-dd'), 3, TO_DATE('2019-01-11', 'yyyy-mm-dd'))
INTO REQUEST (REQ_ID, TITLE, SUMMARY, REQ_EMP, AMOUNT, REQ_DATE, STATUS, STATUS_DATE)
VALUES(3, 'Sales Pitch', 'Pitched to Beta', 2, 60,TO_DATE('2019-09-21', 'yyyy-mm-dd'), 2, TO_DATE('2019-01-11', 'yyyy-mm-dd'))
SELECT * FROM DUAL;
/

--INSERTING DUMMY DATA INTO RECEIPT
INSERT ALL
INTO RECEIPT (RCT_ID, REQ_NUM)
VALUES(1, 1)
INTO RECEIPT (RCT_ID, REQ_NUM)
VALUES(2, 2)
INTO RECEIPT (RCT_ID, REQ_NUM)
VALUES(3, 1)
INTO RECEIPT (RCT_ID, REQ_NUM)
VALUES(4, 3)
SELECT * FROM DUAL;
/


--SET UP SEQUENCES TO PRODUCE PRIMARY KEYS 
CREATE SEQUENCE SQ_EMP_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_REQ_PK
START WITH 1
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_RCT_PK
START WITH 1
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_CRED_PK
START WITH 1
INCREMENT BY 1;
/

--TRIGGERS: CREATE "BEFORE" OR "AFTER TRIGGERS
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
BEFORE INSERT ON EMPLOYEE --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_EMP_PK.NEXTVAL INTO :NEW.EMP_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_REQUEST
BEFORE INSERT ON REQUEST --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_REQ_PK.NEXTVAL INTO :NEW.REQ_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TR_INSERT_RECEIPT
BEFORE INSERT ON RECEIPT --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_RCT_PK.NEXTVAL INTO :NEW.RCT_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TR_INSERT_CREDENTIALS
BEFORE INSERT ON CREDENTIALS --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE
FOR EACH ROW
BEGIN
    SELECT SQ_CRED_PK.NEXTVAL INTO :NEW.CRED_ID FROM DUAL;
END;
/

CREATE OR REPLACE PROCEDURE SP_CREATE_NEW_REQUEST(E_ID IN NUMBER, TIT IN VARCHAR2, SUMM IN VARCHAR2, AMT IN NUMBER)
IS
--DECLARE VARIABLE
E_EXISTS NUMBER;
R_DATE DATE;
BEGIN
    SELECT count(REQ_EMP) INTO E_EXISTS FROM REQUEST WHERE REQUEST.REQ_EMP = E_ID;
    IF E_EXISTS > 0 THEN
    R_DATE := SYSDATE;
    INSERT INTO REQUEST (TITLE, SUMMARY, REQ_EMP, AMOUNT, REQ_DATE, STATUS) VALUES (TIT, SUMM, E_ID, AMT, R_DATE, 1);
        END IF;
    COMMIT;
    --EXCEPTION HANDLING
    EXCEPTION
        WHEN OTHERS THEN
        ROLLBACK;
END;
/

CREATE OR REPLACE PROCEDURE SP_RESOLVE_REQUEST(R_ID IN NUMBER, ST IN NUMBER)
IS
--DECLARE VARIABLE
R_EXISTS NUMBER;
S_DATE DATE;
BEGIN
    SELECT count(REQ_ID) INTO R_EXISTS FROM REQUEST WHERE REQUEST.REQ_ID = R_ID;
    IF R_EXISTS > 0 THEN
    S_DATE := SYSDATE;
    UPDATE REQUEST SET STATUS = ST, STATUS_DATE = S_DATE WHERE REQ_ID = R_ID;
        END IF;
    COMMIT;
    --EXCEPTION HANDLING
    EXCEPTION
        WHEN OTHERS THEN
        ROLLBACK;
END;
/   

COMMIT;