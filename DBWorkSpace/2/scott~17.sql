SELECT ename,
       RTRIM(ename,'R') "rtrim"
FROM emp
WHERE deptno = 10
;