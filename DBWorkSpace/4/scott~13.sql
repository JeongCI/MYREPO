SELECT deptno, job, AVG(NVL(sal,0)) "avg_sal", count(*) "cnt_emp"
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY 1,2
;