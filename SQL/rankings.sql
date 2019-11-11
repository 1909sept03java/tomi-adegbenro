--SELECTING NTH POSITION RANKING USING "WITH"
WITH RESULT AS (
select salary, DENSE_RANK() OVER
      (ORDER BY salary DESC) as denserank from employees)
      SELECT SALARY FROM RESULT WHERE DENSERANK = 2;

--SELECTING NTH POSITION RANKING BY BUILDING A VIEW      
create or replace view my_result
as
select salary, DENSE_RANK() OVER
      (ORDER BY salary DESC) as denserank from employees group by salary;
      
select * from my_result where denserank =4;

--SELECTING 2ND HIGHEST SALARY
select max(salary) from employees where salary < (select max(salary) from employees);

--PRACTICING ORDER BY
SELECT EMP_FIRSTNAME, SALARY, DEPARTMENT_ID FROM EMPLOYEES ORDER BY DEPARTMENT_ID;

--PRACTICING GROUP BY
SELECT DEPARTMENT_ID, AVG(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID;