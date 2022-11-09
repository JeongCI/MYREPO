explain plan for

SELECT deptno, job, AVG(NVL(sal,0)), COUNT(*) "CNT_EMP"
FROM emp
GROUP BY CUBE(deptno, job)
ORDER BY 1,2
;

col plan_table_output format a80
SELECT *
FROM table(dbms_xplan.display)
;