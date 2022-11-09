explain plan for

SELECT deptno, job, AVG(NVL(sal,0)), COUNT(*) "CNT_EMP"
FROM emp
GROUP BY deptno, job
UNION ALL
SELECT deptno, NULL as job, AVG(NVL(sal,0)), COUNT(*) "CNT_EMP"
FROM emp
GROUP BY deptno
UNION ALL
SELECT NULL as deptno, NULL as job, AVG(NVL(sal,0)), COUNT(*) "CNT_EMP"
FROM emp
ORDER BY deptno, job
;

col plan_table_output format a80
SELECT *
FROM table(dbms_xplan.display)
;