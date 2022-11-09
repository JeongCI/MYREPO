SELECT deptno,position, COUNT(*), SUM(pay)
FROM professor
GROUP BY deptno, ROLLUP(position)
ORDER BY 1,2
;