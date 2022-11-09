SELECT LPAD(ename,9,'123456789') "LPAD"
FROM emp
WHERE deptno = 10
;

SELECT ename,
       RPAD(ename,10,'-')
FROM emp
WHERE deptno = 10
;

SELECT RPAD(ename,9,SUBSTR('123456789',LENGTH(ename)+1)) "RPAD"
FROM emp
WHERE deptno = 10
;

