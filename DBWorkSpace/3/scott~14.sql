SELECT studno,
       name,
       TO_CHAR(birthday,'YYYY-MM-DD') "BIRTHDAY"
FROM student
WHERE TO_CHAR(birthday,'MM') = 01
;

SELECT deptno,
       ename,
       TO_CHAR(hiredate,'YYYY-MM-DD') "hiredate"
FROM emp
WHERE TO_CHAR(hiredate,'MM')IN('01','02','03')
;