/*******************************************************************************
   CodeChallenge2 Database - Version 1.4
   Script:codeChallenge2.sql
   Description: database.
   DB Server: Oracle
   Author: Tomi Adegbenro
   License: http://www.codeplex.com/ChinookDatabase/licensenull
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER tomi CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER tomi
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to tomi;
GRANT resource to tomi;
GRANT create session TO tomi;
GRANT create table TO tomi;
GRANT create view TO tomi;



conn tomi/p4ssw0rd

DROP TABLE Employees;
DROP TABLE Departments;
/

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE Employees
(
    Employee_Id NUMBER NOT NULL,
    Emp_LastName VARCHAR2(20) NOT NULL,
    Emp_FirstName VARCHAR2(20) NOT NULL,
    Salary NUMBER,
    Department_Id NUMBER,
    CONSTRAINT PK_Employee PRIMARY KEY  (Employee_Id)
);

CREATE TABLE Departments
(
    Department_Id NUMBER NOT NULL,
    Department_Name VARCHAR2(120),
    CONSTRAINT PK_Genre PRIMARY KEY  (Department_Id)
);

--FOREIGN KEY CONSTRAINTS 

ALTER TABLE Employees
ADD CONSTRAINT FK_DEPARTMENT_ID
FOREIGN KEY (Department_Id) REFERENCES Departments(Department_Id);
/

--SET UP SEQUENCES TO PRODUCE PRIMARY KEYS 
CREATE SEQUENCE SQ_Employees_PK
START WITH 1
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_Departments_PK
START WITH 1
INCREMENT BY 1;
/

--SET UP TRIGGERS: 
CREATE OR REPLACE TRIGGER TR_INSERT_Employees
BEFORE INSERT ON Employees --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE 
FOR EACH ROW
BEGIN
    SELECT SQ_Employees_PK.NEXTVAL INTO :NEW.Employee_Id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_Departments
BEFORE INSERT ON Departments --SPECIFY OPERATION, BEFORE/AFTER, AND TABLE 
FOR EACH ROW
BEGIN
    SELECT SQ_Departments_PK.NEXTVAL INTO :NEW.Department_Id FROM DUAL;
END;
/

--INSERTING DATA INTO TABLES
INSERT ALL
INTO Departments (Department_Name)
VALUES('Finance')
INTO Departments (Department_Name)
VALUES('Technology')
INTO Departments (Department_Name)
VALUES('Projects')
SELECT * FROM DUAL; --DUAL IS A DUMMY TABLE, PLSQL USES IT TO MAKE STATEMENTS FIT QUERY FORMAT

--SELECT * FROM DUAL;

INSERT ALL
INTO Employees(Emp_FirstName, Emp_LastName, Salary, Department_Id)
VALUES ('John', 'Sullivan', 50000, 1)
INTO Employees(Emp_FirstName, Emp_LastName, Salary, Department_Id)
VALUES ('Mitch', 'Daniels', 55000, 2)
INTO Employees(Emp_FirstName, Emp_LastName, Salary, Department_Id)
VALUES ('Tunde', 'Ade', 65000, 1)
INTO Employees(Emp_FirstName, Emp_LastName, Salary, Department_Id)
VALUES ('John', 'Williams', 50000, 3)
INTO EMployees(Emp_FirstName, Emp_LastName, Salary, Department_Id)
VALUES ('Daphne', 'Jordan', 47000, 2)
INTO EMployees(Emp_FirstName, Emp_LastName, Salary, Department_Id)
VALUES ('Tiffany', 'Ryan', 80000, 1)
SELECT * FROM DUAL;
/
--drop table DEPARTNMENTS;
--COMMIT;
--/
select * from Departments;
/

CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE(DEPT_ID IN NUMBER, DEPT_LIST OUT SYS_REFCURSOR)
IS
--VARIABLES

BEGIN
    OPEN DEPT_LIST FOR
        SELECT EMP_FIRSTNAME, EMP_LASTNAME, SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID = DEPT_ID;
        UPDATE EMPLOYEES SET SALARY = SALARY * 1.1 WHERE DEPARTMENT_ID = DEPT_ID; 
    COMMIT;
    --EXCEPTION HANDLING!
    EXCEPTION
    --https://docs.oracle.com/cd/B10501_01/appdev.920/a96624/07_errs.htm
    WHEN OTHERS THEN
    DEPT_LIST := NULL;
    ROLLBACK;
END;

DECLARE
S SYS_REFCURSOR;
FNAME EMPLOYEES.EMP_FIRSTNAME%TYPE;
LNAME EMPLOYEES.EMP_LASTNAME%TYPE;
SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SP_GIVE_RAISE(1,S);
    LOOP
    FETCH S INTO FNAME, LNAME, SALARY;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('NAME: '||FNAME ||' '||LNAME||'; SALARY: '||SALARY);
    END LOOP;
    CLOSE S;
END;
/
--TESTING
UPDATE EMPLOYEES SET SALARY = SALARY * 1.1 WHERE DEPARTMENT_ID = 1;
/
--SELECT DEPARTMENTS.DEPARTMENT_ID, AVG(EMPLOYEES.SALARY), DEPARTMENTS.DEPARTMENT_NAME FROM DEPARTMENTS LEFT OUTER JOIN EMPLOYEES ON DEPARTMENTS.DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID 
--    GROUP BY DEPARTMENTS.DEPARTMENT_ID, employees.salary, DEPARTMENTS.DEPARTMENT_NAME ORDER BY DEPARTMENTS.DEPARTMENT_ID;
/
SELECT DEPARTMENTS.DEPARTMENT_ID, count(EMPLOYEES.DEPARTMENT_ID), DEPARTMENTS.DEPARTMENT_NAME FROM DEPARTMENTS LEFT OUTER JOIN EMPLOYEES ON DEPARTMENTS.DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID 
    GROUP BY DEPARTMENTS.DEPARTMENT_ID, EMPLOYEES.DEPARTMENT_ID, DEPARTMENTS.DEPARTMENT_NAME;-- ORDER BY DEPARTMENTS.DEPARTMENT_ID;
/
SELECT DEPARTMENTS.DEPARTMENT_ID, AVG(EMPLOYEES.SALARY), DEPARTMENTS.DEPARTMENT_NAME FROM DEPARTMENTS LEFT OUTER JOIN EMPLOYEES ON DEPARTMENTS.DEPARTMENT_ID = EMPLOYEES.DEPARTMENT_ID
    GROUP BY DEPARTMENTS.DEPARTMENT_ID, EMPLOYEES.SALARY, DEPARTMENTS.DEPARTMENT_NAME HAVING EMPLOYEES.SALARY >0;-- ORDER BY DEPARTMENTS.DEPARTMENT_ID;
/
SELECT AVG(EMPLOYEES.SALARY), EMPLOYEES.DEPARTMENT_ID, DEPARTMENTS.DEPARTMENT_NAME FROM EMPLOYEES INNER JOIN DEPARTMENTS ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID; GROUP BY EMPLOYEES.SALARY, EMPLOYEES.DEPARTMENT_ID, DEPARTMENTS.DEPARTMENT_NAME;