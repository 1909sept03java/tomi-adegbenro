  
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
