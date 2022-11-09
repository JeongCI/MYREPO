SELECT empno,
       ename,
       comm,
       NVL2(comm,'Exist','NULL') "NVL2"
FROM emp
WHERE deptno = 30
;