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
select company,number_of_employees from companies
where number_of_employees = (select max(number_of_employees)from companies
where number_of_employees < (select max(number_of_employees) from companies) );
--2. way:
select number_of_employees from companies
order by number_of_employees desc
offset 1 row limit 1


--2.Example: Find the company names and number of employees
--whose number of employees is less than the average number of employees
select company, number_of_employees from companies
where number_of_employees < (select avg(number_of_employ) from employees);


--3.Example: Update the number of employees to 16000
--if the number of employees is less than the average number of employees
update companies
set number_of_employees = 16000
where number_of_employees < (select avg(number_of_employees) from employees);

--4.Example: Update the number of employees to 9999
--if the company name is IBM by using prepared statement

update company
set number_of_employees = 9999
where company = 'IBM';


drop table companies;

-----------------------------------------------------
--1.Example: Create a function which uses 2 parameters and return the sum of the parameters

create or replace function addF(x numeric, y numeric) returns numeric language plpgsql as
$$ begin
return x + y;
end $$;

drop table workers;


















