SELECT SUM(sal),
       SUM(DISTINCT sal),
       SUM(ALL sal)
FROM emp
;