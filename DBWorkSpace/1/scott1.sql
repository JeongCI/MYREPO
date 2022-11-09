SELECT ename || '''s sal is &' ||  sal "NAME and Sal"
FROM emp
;

SELECT *
FROM emp
ORDER BY sal DESC, deptno ASC
;

SELECT distinct job
FROM emp
;

SELECT empno  "EMPLOYEE_NO",
       ename "EMPLOYEE_NAME",
       mgr "NANAGER",
       sal "SALARY",
       comm "COMMISSION",
       deptno "DEPARTMENT_NO" 
FROM emp
ORDER BY deptno desc, ename asc
;

SELECT *
FROM emp
WHERE deptno = 30
;

SELECT *
FROM emp
WHERE empno = 7900
;

SELECT *
FROM emp
WHERE ename = 'SMITH'
;

SELECT ename,
       hiredate
FROM emp
WHERE hiredate = '80/12/17'
;

SELECT ename,
       sal,
       sal+100
FROM emp
WHERE deptno = 10
;

SELECT *
FROM emp
WHERE DEPTNO = 30 
AND JOB = 'SALESMAN'
;

SELECT *
FROM emp
WHERE deptno = 30
OR job = 'CLERK'
;

SELECT *
FROM emp
WHERE deptno = 30
OR job = 'CLERK'
;

SELECT *
FROM emp
WHERE SAL*12 = 36000
;

SELECT empno,
       ename,
       sal
FROM emp
WHERE sal >= 4000
;

SELECT empno,
       ename,
       sal
FROM emp
WHERE ename >= 'E'
ORDER BY ename
;

SELECT *
FROM emp
WHERE sal ^= 3000
;

SELECt *
FROM emp
WHERE NOT sal = 3000
;

SELECT *
FROM emp
WHERE JOB = 'SALESMAN'
OR JOB = 'MANAGER'
OR JOB = 'CLERK'
ORDER BY job
;

SELECT *
FROM emp
WHERE JOB IN ('MANAGER', 'SALESMAN', 'CLERK')
ORDER BY job
;

SELECT *
FROM emp
WHERE JOB NOT IN ('MANAGER', 'SALESMAN', 'CLERK')
;

SELECT *
FROM emp
WHERE sal >= 2000
AND sal <= 3000
ORDER BY sal
;

SELECT *
FROM emp
WHERE sal BETWEEN 2000 AND 3000
;

SELECT *
FROM emp
WHERE sal NOT BETWEEN 2000 AND 3000
;

SELECT *
FROM emp
WHERE ename LIKE 'S%'
ORDER BY ename
;

SELECT *
FROM emp
WHERE ename LIKE '_L%'
ORDER BY ename
;

SELECT *
FROM emp
WHERE ename LIKE '%AM%'
ORDER BY ename
;

SELECT *
FROM emp
WHERE ename NOT LIKE '%AM%'
ORDER BY ename
;

SELECT *
FROM emp
WHERE sal LIKE '1%'
;

