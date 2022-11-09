SELECT deptno,
       TRUNC(AVG(sal)) "AVG_SAL",
       MAX(sal) "MAX_SAL",
       MIN(sal) "MIN_SAL",
       COUNT(deptno)
FROM emp
GROUP BY deptno 
ORDER BY deptno desc
;

SELECT job,
       COUNT(*)
FROM emp
GROUP BY job
HAVING COUNT(*) >= 3
;