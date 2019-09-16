  
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
/*******************************************************************************
 3.1.1 FUNCTIONS - GET_CURRENT TIME
********************************************************************************/
CREATE OR REPLACE FUNCTION GET_CURRENT_TIME
RETURN TIMESTAMP
IS
CT TIMESTAMP;
BEGIN
   CT := CURRENT_TIMESTAMP;
    RETURN CT;
END;
/
--CALL OUR FUNCTION GET_CURRENT_TIME
DECLARE 
CURRENT_TIME TIMESTAMP;
BEGIN
    --FIRST_NUM := 22;
    --SECOND_NUM := 42;
    CURRENT_TIME := GET_CURRENT_TIME;
    DBMS_OUTPUT.PUT_LINE('CURRENT TIME IS: '||CURRENT_TIME); --JUST LIKE A SYSOUT IN JAVA
END;
/

/*******************************************************************************
3.1.2 FUNCTION - GET STRING LENGTH
********************************************************************************/
--CREATING FUNCTION TO GET ALL MEDIATYPE NAMES
CREATE OR REPLACE FUNCTION GET_MEDIATYPE_NAME
RETURN SYS_REFCURSOR
IS
S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT NAME FROM MEDIATYPE;
    RETURN S;
END;
/
--CREATING FUNCTION TO RETURN STRING LENGTH
CREATE OR REPLACE FUNCTION GET_STRING_LENGTH(S IN VARCHAR2)
RETURN NUMBER
IS
S_LENGTH NUMBER;
BEGIN
    S_LENGTH := LENGTH(S);
    RETURN S_LENGTH;
END;

--INVOKE GET_MEDIATYPE_NAME AND GET_STRING_LENGTH FUNCTIONS 
DECLARE
S SYS_REFCURSOR;
S_LENGTH NUMBER;
NAME MEDIATYPE.NAME%TYPE; -- DECLARES THAT NAME IS OF THE SAME DATATYPE AS MEDIATYPE.NAME
BEGIN
    S := GET_MEDIATYPE_NAME;
    LOOP
    FETCH S INTO NAME; -- GRAB VALUES IN COLUMNS OF NEXT ROW IN ACTIVE SET
    S_LENGTH := GET_STRING_LENGTH(NAME);
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('LENGTH OF MEDIATYPE NAME IS : '||S_LENGTH);
    END LOOP;
    CLOSE S;
END;
/
/*******************************************************************************
 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
********************************************************************************/
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN SYS_REFCURSOR
IS
S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT TRACK.NAME, UNITPRICE, MEDIATYPE.NAME AS MNAME 
        FROM TRACK INNER JOIN MEDIATYPE ON TRACK.MEDIATYPEID = MEDIATYPE.MEDIATYPEID 
        WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
    RETURN S;
END;
/

DECLARE
S SYS_REFCURSOR;
T_NAME TRACK.NAME%TYPE;
T_PRICE TRACK.UNITPRICE%TYPE;
T_MEDIATYPE MEDIATYPE.NAME%TYPE;
BEGIN
    S := MOST_EXPENSIVE_TRACK;
    LOOP
    FETCH S INTO T_NAME, T_PRICE, T_MEDIATYPE; -- GRAB VALUES IN COLUMNS OF NEXT ROW IN ACTIVE SET
    --S_LENGTH := GET_STRING_LENGTH(NAME);
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('TRACK : '||T_NAME||'; MEDIATYPE : '||T_MEDIATYPE||'PRICE : '||T_PRICE);
    END LOOP;
    CLOSE S;
END;
/

/*******************************************************************************
 3.3 USER DEFINED SCALAR FUNCTIONS
********************************************************************************/
/
CREATE OR REPLACE FUNCTION GET_PRICES
RETURN SYS_REFCURSOR
IS
S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT UNITPRICE FROM INVOICELINE;
    RETURN S;
END;
/

CREATE OR REPLACE FUNCTION GET_PRICES_COUNT --(S IN SYS_REFCURSOR)
RETURN SYS_REFCURSOR
IS
S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT COUNT(UNITPRICE) FROM INVOICELINE;
    RETURN S;
END;
/

CREATE OR REPLACE FUNCTION GET_AVGPRICE(S IN NUMBER, C IN NUMBER)
RETURN NUMBER
IS
AVGPRICE NUMBER;
BEGIN
    AVGPRICE := S / C;
    RETURN AVGPRICE;
END;

DECLARE
S SYS_REFCURSOR;
R SYS_REFCURSOR;
PRICE INVOICELINE.UNITPRICE%TYPE;
SUMPRICE NUMBER;
CT NUMBER;
AVGPRICE NUMBER(10,2);
BEGIN
    SUMPRICE := 0;
    S := GET_PRICES;
    R := GET_PRICES_COUNT;
    LOOP
    FETCH S INTO PRICE; 
    SUMPRICE := SUMPRICE + PRICE;
    EXIT WHEN S%NOTFOUND;
    END LOOP;
    CLOSE S;
    
    LOOP
    FETCH R INTO CT;
    EXIT WHEN R%NOTFOUND;
    END LOOP;
    CLOSE R;
    AVGPRICE := GET_AVGPRICE(SUMPRICE, CT);
    DBMS_OUTPUT.PUT_LINE('SUM OF PRICES: '||SUMPRICE ||' COUNT: '||CT||' AVGPRICE: '||AVGPRICE);
END;
/

/*******************************************************************************
 3.4 USER DEFINED SCALAR FUNCTIONS
********************************************************************************/
CREATE OR REPLACE FUNCTION GET_EMP_AFTERYEAR (YR IN VARCHAR2)--(S IN SYS_REFCURSOR)
RETURN SYS_REFCURSOR
IS
S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME, BIRTHDATE FROM EMPLOYEE WHERE BIRTHDATE > TO_DATE(YR, 'YYYY');
    RETURN S;
END;
/

DECLARE
S SYS_REFCURSOR;
FNAME EMPLOYEE.FIRSTNAME%TYPE;
LNAME EMPLOYEE.LASTNAME%TYPE;
BDAY EMPLOYEE.BIRTHDATE%TYPE;
YR VARCHAR2(50);
BEGIN
    YR := '1968';
    S:= GET_EMP_AFTERYEAR(YR);
    LOOP
    FETCH S INTO FNAME, LNAME, BDAY; 
    DBMS_OUTPUT.PUT_LINE('FIRST NAME: '||FNAME ||' LAST NAME: '||LNAME||' BIRTHDAY: '||BDAY);
    EXIT WHEN S%NOTFOUND;
    END LOOP;
    CLOSE S;
END;
/

/*******************************************************************************
 4.0 STORED PROCEDURES
********************************************************************************/
/*******************************************************************************
 4.1 BASIC STORED PROCEDURE
********************************************************************************/
CREATE OR REPLACE PROCEDURE SP_LIST_EMPLOYEES(EMP_LIST OUT SYS_REFCURSOR)
IS 
--S SYS_REFCURSOR;
BEGIN
    OPEN EMP_LIST FOR
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
    COMMIT;
    --EXCEPTION HANDLING!
    EXCEPTION
    --https://docs.oracle.com/cd/B10501_01/appdev.920/a96624/07_errs.htm
    WHEN OTHERS THEN
    EMP_LIST := NULL;
    ROLLBACK;
END;

DECLARE
S SYS_REFCURSOR;
FNAME EMPLOYEE.FIRSTNAME%TYPE;
LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    SP_LIST_EMPLOYEES(S);
    LOOP
    FETCH S INTO FNAME, LNAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('FIRST NAME: '||FNAME ||' LAST NAME: '||LNAME);
    END LOOP;
    CLOSE S;
END;
/
/*******************************************************************************
 4.2 BASIC STORED PROCEDURE - UPDATE PERSONAL INFO
********************************************************************************/
CREATE OR REPLACE PROCEDURE SP_EMP_UPDATE_EMAIL(EMP_ID IN INTEGER, U_EMAIL IN VARCHAR2, OLD_EMAIL OUT VARCHAR2, NEW_EMAIL OUT VARCHAR2)
IS 
BEGIN
    --QUERY THE OLD EMAIL
    SELECT EMAIL INTO OLD_EMAIL FROM EMPLOYEE WHERE EMPLOYEEID = EMP_ID;
    UPDATE EMPLOYEE SET EMPLOYEE.EMAIL = U_EMAIL WHERE EMPLOYEEID = EMP_ID;
    --QUERY THE NEW EMAIL
    SELECT EMAIL INTO NEW_EMAIL FROM EMPLOYEE WHERE EMPLOYEEID = EMP_ID;
    COMMIT;
    --EXCEPTION HANDLING!
    EXCEPTION
    --https://docs.oracle.com/cd/B10501_01/appdev.920/a96624/07_errs.htm
    WHEN OTHERS THEN
        UPDATE EMPLOYEE SET EMPLOYEE.EMAIL = OLD_EMAIL WHERE EMPLOYEEID = EMP_ID;
    ROLLBACK;
END;

DECLARE
EMP_ID INTEGER;
OLD_EMAIL EMPLOYEE.EMAIL%TYPE;
NEW_EMAIL EMPLOYEE.EMAIL%TYPE;
BEGIN
    EMP_ID:= 2;
    SP_EMP_UPDATE_EMAIL(EMP_ID, 'nancye@chinookcorp.com', OLD_EMAIL, NEW_EMAIL);
    
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE WITH '||EMP_ID||': EMAIL CHANGED FROM '||OLD_EMAIL||' TO '||NEW_EMAIL);
END;

/*******************************************************************************
 4.2 STORED PROCEDURE INPUT PARAMS - RETURN EMPLOYEE MANAGER
********************************************************************************/
CREATE OR REPLACE PROCEDURE SP_EMP_MANAGER(EMP_ID IN INTEGER, MGR_INFO OUT SYS_REFCURSOR)
IS 
MGR_ID NUMBER;
BEGIN
    SELECT REPORTSTO INTO MGR_ID FROM EMPLOYEE WHERE EMPLOYEEID = EMP_ID;
    OPEN MGR_INFO FOR
        SELECT FIRSTNAME, LASTNAME, TITLE FROM EMPLOYEE WHERE EMPLOYEEID = MGR_ID;
    COMMIT;
    --EXCEPTION HANDLING!
    EXCEPTION
    --https://docs.oracle.com/cd/B10501_01/appdev.920/a96624/07_errs.htm
    WHEN OTHERS THEN
    MGR_INFO := NULL;
    ROLLBACK;
END;

DECLARE
MGR SYS_REFCURSOR;
F_NAME EMPLOYEE.FIRSTNAME%TYPE;
L_NAME EMPLOYEE.LASTNAME%TYPE;
TITLE EMPLOYEE.TITLE%TYPE;

--LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    SP_EMP_MANAGER(6,MGR);
    LOOP
    FETCH MGR INTO F_NAME, L_NAME, TITLE;
    EXIT WHEN MGR%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('MANGERS NAME: '||F_NAME ||' '||L_NAME||' TITLE: '||TITLE);
    END LOOP;
    CLOSE MGR;
END;
/

/*******************************************************************************
 4.3 STORED PROCEDURE OUTPUT PARAMS - RETURN CUSTOMER_COMPANY INFO
********************************************************************************/
CREATE OR REPLACE PROCEDURE SP_CUS_COMP_INFO(CUS_LIST OUT SYS_REFCURSOR)
IS 
--S SYS_REFCURSOR;
BEGIN
    OPEN CUS_LIST FOR
        SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE COMPANY IS NOT NULL;
    COMMIT;
    --EXCEPTION HANDLING!
    EXCEPTION
    --https://docs.oracle.com/cd/B10501_01/appdev.920/a96624/07_errs.htm
    WHEN OTHERS THEN
    CUS_LIST := NULL;
    ROLLBACK;
END;

DECLARE
S SYS_REFCURSOR;
FNAME CUSTOMER.FIRSTNAME%TYPE;
LNAME CUSTOMER.LASTNAME%TYPE;
COMPANY CUSTOMER.COMPANY%TYPE;
BEGIN
    SP_CUS_COMP_INFO(S);
    LOOP
    FETCH S INTO FNAME, LNAME, COMPANY;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('NAME: '||FNAME ||' '||LNAME||'; COMPANY: '||COMPANY);
    END LOOP;
    CLOSE S;
END;

/*******************************************************************************
 5. TRANSACTIONS
********************************************************************************/
CREATE OR REPLACE PROCEDURE SP_TRY_TRANSACTIONS(INV_ID IN INTEGER)
IS
BEGIN
    --PERFORM DELETION
    DELETE FROM INVOICE WHERE INVOICEID = INV_ID;
    
    COMMIT;
    --EXCEPTION HANDLING!
    EXCEPTION
    --https://docs.oracle.com/cd/B10501_01/appdev.920/a96624/07_errs.htm
    WHEN OTHERS THEN ROLLBACK;
        --UPDATE EMPLOYEE SET EMPLOYEE.EMAIL = OLD_EMAIL WHERE EMPLOYEEID = EMP_ID;
    --ROLLBACK;
END;

DECLARE
INV_ID INTEGER;
--OLD_EMAIL EMPLOYEE.EMAIL%TYPE;
--NEW_EMAIL EMPLOYEE.EMAIL%TYPE;
BEGIN
    INV_ID:= 450;
    SP_TRY_TRANSACTIONS(INV_ID);
    --DBMS_OUTPUT.PUT_LINE('EMPLOYEE WITH '||EMP_ID||': EMAIL CHANGED FROM '||OLD_EMAIL||' TO '||NEW_EMAIL);
END;
/
/*******************************************************************************
 6. TRIGGERS
********************************************************************************/
/*******************************************************************************
 6.1 TRIGGERS - AFTER INSERT TRIGGER*
********************************************************************************/
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE  
FOR EACH ROW
DECLARE

BEGIN
    UPDATE EMPLOYEE SET :REPORTSTO = 1;
    --SELECT SQ_BEAR_TYPE_PK.NEXTVAL INTO :NEW.BEAR_TYPE_ID FROM DUAL;
END;
/

--INITIATE TRIGGER
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME, HIREDATE) VALUES (20, 'Jim', 'Brownsville', TO_DATE('10-21-2005', 'MM-DD-YYYY');
/
/*******************************************************************************
 7. JOINS
********************************************************************************/
/*******************************************************************************
 7.1 INNER JOIN - MERGING TWO COLUMNS
********************************************************************************/
--SELECT FIRSTNAME, LASTNAME, INVOICE.INVOICEID AS INVOICE_NUM FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
SELECT (FIRSTNAME||' '|| LASTNAME) EMPLOYEENAME, INVOICE.INVOICEID AS INVOICE_NUM FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
/
/*******************************************************************************
 7.2 OUTER JOIN
********************************************************************************/
SELECT FIRSTNAME, LASTNAME, INVOICE.INVOICEID AS INVOICE_NUM, INVOICE.TOTAL AS TOTAL FROM CUSTOMER LEFT OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
/
/*******************************************************************************
 7.3 RIGHT JOIN
********************************************************************************/
SELECT TITLE, ARTIST.NAME AS ARTIST FROM ALBUM RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;
/
/*******************************************************************************
 7.4 CROSS JOIN - USED AS AN INNER JOIN
********************************************************************************/
SELECT * FROM ARTIST CROSS JOIN ALBUM WHERE ALBUM.ARTISTID = ARTIST.ARTISTID;
/

/*******************************************************************************
 7.5 SELF JOIN - 
********************************************************************************/
SELECT
    (e.FIRSTNAME || '  ' || e.LASTNAME) emp, (m.FIRSTNAME || '  ' || m.LASTNAME) mgr,
    e.TITLE
    FROM EMPLOYEE e 
        LEFT JOIN EMPLOYEE m ON m.EMPLOYEEID = e.REPORTSTO
        ORDER BY mgr;
/


--TESTING
SELECT INVOICELINEID, UNITPRICE, QUANTITY, INVOICE.INVOICEID, INVOICE.TOTAL AS INVOICE_TOTAL FROM INVOICELINE INNER JOIN INVOICE ON INVOICELINE.INVOICEID = INVOICE.INVOICEID;
SELECT * FROM INVOICE WHERE INVOICEID = 61;
SELECT * FROM INVOICELINE WHERE INVOICEID = 61;
SELECT FIRSTNAME, BIRTHDATE FROM EMPLOYEE WHERE BIRTHDATE > TO_DATE('1968', 'YYYY');
INSERT INTO INVOICE (INVOICEID, CUSTOMERID, INVOICEDATE, TOTAL) VALUES(450,3, TO_DATE('10-21-2005', 'MM-DD-YYYY'), 500.00);

CREATE OR REPLACE PROCEDURE TEST
IS
BEGIN
    INSERT INTO GENRE (100, 'Jim Jim');
    COMMIT;