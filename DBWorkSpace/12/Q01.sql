SELECT deptno,
       SUM(DECODE(job,'CLERK',sal,'0')) "CLERK",
       SUM(DECODE(job,'MANAGER',sal,'0')) "MANAGER",
       SUM(DECODE(job,'PRESIDENT',sal,'0')) "PRESIDENT",
       SUM(DECODE(job,'ANALYST',sal,'0')) "ANALYST",
       SUM(DECODE(job,'SALESMAN',sal,'0')) "SALESMAN",
       SUM(sal) "TOTAL"
FROM emp
GROUP BY ROLLUP(DEPTNO)
ORDER BY deptno
;