SELECT deptno, job, AVG(NVL(sal,0)) "avg_sal", count(*) "cnt_emp"
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY 1,2
;

SELECT deptno,position, COUNT(*), SUM(pay)
FROM professor
GROUP BY position, ROLLUP(deptno)
ORDER BY 2,1
;

SELECT deptno, position
FROM professor
;