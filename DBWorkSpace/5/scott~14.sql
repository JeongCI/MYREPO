SELECT TO_CHAR(hiredate,'YYYY') "HIRE_YEAR",
       deptno,
       COUNT(*)
FROM emp
GROUP BY TO_CHAR(hiredate,'YYYY'), deptno
ORDER BY TO_CHAR(hiredate,'YYYY') DESC, deptno
;