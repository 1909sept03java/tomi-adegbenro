  
/*******************************************************************************
   Revature SQL Lab
   Script: Chinook.sql
   Description: Tasks to practice SQL queries.
   DB Server: Oracle
   Author: Tomi Adegbenro 
********************************************************************************/

/*******************************************************************************
  2.  SQL QUERIES
********************************************************************************/

/*******************************************************************************
  2.1 SELECT
********************************************************************************/
SELECT * FROM EMPLOYEE;
/

SELECT * FROM employee WHERE lastname ='King';
/

SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto is null;
/

/*******************************************************************************
  2.2  ORDER BY
********************************************************************************/
SELECT * FROM album ORDER BY title DESC;
/

SELECT FIRSTNAME FROM customer ORDER BY city ASC;
/

/*******************************************************************************
  2.3 INSERT INTO
********************************************************************************/

INSERT ALL
INTO GENRE
VALUES(26, 'Afro Beats')
INTO GENRE (GENREID, NAME)
VALUES (27, 'Country')
SELECT * FROM DUAL;
/


INSERT ALL
INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL, PHONE)
VALUES (60, 'Talbert', 'Winetree', 'twindetree@apple.com', '+1 (512) 755 1233')
INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL, PHONE)
VALUES (61, 'Timothy', 'Adegbenro', 'grungy@apple.com', '+1 (718) 999 2299')
SELECT * FROM DUAL;
/

INSERT ALL
INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME, EMAIL, PHONE, HIREDATE, TITLE)
VALUES (9, 'Jim', 'Coltrane', 'jcoltrane@chinookcorp.com', '+1 (515) 125 6935', TO_DATE('2007-9-11', 'yyyy-mm-dd'), 'IT Director')
INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME, EMAIL, PHONE, HIREDATE, TITLE)
VALUES (10, 'Tim', 'Galligan', 'tgalligan@chinookcorp.com', '+1 (515) 125 6912', TO_DATE('2004-1-15', 'yyyy-mm-dd'), 'Sales Support Agent')
SELECT * FROM DUAL;
/   

/*******************************************************************************
  2.4 UPDATE
********************************************************************************/
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
/

UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
/

/*******************************************************************************
  2.5 LIKE
********************************************************************************/
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
/

/*******************************************************************************
  2.6 BETWEEN
********************************************************************************/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
/

SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('2003-6-1', 'yyyy-mm-dd') AND TO_DATE('2004-3-1', 'yyyy-mm-dd');
/

/*******************************************************************************
  2.7 DELETE
********************************************************************************/
--UPDATE INVOICE SET CUSTOMERID = NULL WHERE CUSTOMERID = 32;
--DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME ='Walter';

DELETE FROM INVOICE
    WHERE CUSTOMERID IN (SELECT CUSTOMERID FROM CUSTOMER 
        WHERE CUSTOMERID =32);

/

/*******************************************************************************
  3. SQL FUNCTIONS
********************************************************************************/

/*******************************************************************************
  3.1 SYSTEM DEFINED FUNCTIONS
********************************************************************************/
CREATE OR REPLACE FUNCTION GET_CURRENT_TIME
RETURN TIMESTAMP
IS
CT TIMESTAMP;
BEGIN
   CT := CURRENT_TIMESTAMP;
    RETURN CT;
END;

--CALL OUR FUNCTION GET_CURRENT_TIME
DECLARE 
CURRENT_TIME TIMESTAMP;
BEGIN
    --FIRST_NUM := 22;
    --SECOND_NUM := 42;
    CURRENT_TIME := GET_CURRENT_TIME;
    DBMS_OUTPUT.PUT_LINE('CURRENT TIME IS: '||CURRENT_TIME); --JUST LIKE A SYSOUT IN JAVA
END;