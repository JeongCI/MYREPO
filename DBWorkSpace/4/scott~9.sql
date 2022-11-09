SELECT AVG(sal),
       deptno
FROM emp
GROUP BY deptno
ORDER BY deptno
;