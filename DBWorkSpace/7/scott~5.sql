CREATE TABLE dept_ddl30
AS
SELECT *
FROM dept
WHERE deptno = 30;

CREATE TABLE dept_ddl_empty
AS
SELECT *
FROM dept
WHERE 1 <> 1;

SELECT * FROM dept_ddl_empty;