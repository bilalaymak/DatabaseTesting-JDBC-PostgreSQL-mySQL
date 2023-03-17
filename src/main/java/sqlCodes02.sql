CREATE TABLE companies
(
  company_id SMALLINT,
  company VARCHAR(20),
  number_of_employees SMALLINT
);

INSERT INTO companies VALUES(100, 'IBM', 12000);
INSERT INTO companies VALUES(101, 'GOOGLE', 18000);
INSERT INTO companies VALUES(102, 'MICROSOFT', 10000);
INSERT INTO companies VALUES(103, 'APPLE', 21000);

SELECT * FROM companies;
 drop table companies;
--1.Example: Find the company and number_of_employees whose number_of_employees is the second highest from the companies table

--1. way:
SELECT company, number_of_employees
FROM companies
WHERE number_of_employees= (SELECT MAX(number_of_employees)
                            FROM companies
                            WHERE number_of_employees < (SELECT MAX(number_of_employees)
                            FROM companies));
--2. way:
SELECT company, number_of_employees
FROM companies
ORDER BY number_of_employees DESC
OFFSET 1 ROW
LIMIT 1


--2.Example: Find the company names and number of employees
--whose number of employees is less than the average number of employees
select company, number_of_employees from companies
where number_of_employees < (select avg(number_of_employees) from companies);


--3.Example: Update the number of employees to 16000
--if the number of employees is less than the average number of employees
 update companies
 set number_of_employees = 16000
 where number_of_employees <(select avg(number_of_employees) from companies);

--4.Example: Update the number of employees to 9999
--if the company name is IBM by using prepared statement
 update companies
 set number_of_employees =9999
 where company = 'IBM';

drop table companies;

-----------------------------------------------------
--1.Example: Create a function which uses 2 parameters and return the sum of the parameters
CREATE OR REPLACE FUNCTION additionF(x NUMERIC, y NUMERIC) RETURNS NUMERIC LANGUAGE plpgsql AS $$ BEGIN RETURN x+y; END $$;
drop table workers;

















