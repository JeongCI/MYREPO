SELECT deptno,
       TO_CHAR(hiredate,'YYYY') "HIRE_YEAR",
       COUNT(TO_CHAR(hiredate,'YYYY')) "CNT",
       MAX(sal) "MAX_SAL",
       SUM(sal) "SUM_SAL",
       TRUNC(AVG(sal),2) "AVG_SAL"
FROM emp
GROUP BY ROLLUP(deptno,TO_CHAR(hiredate,'YYYY'))
ORDER BY 1,2
;