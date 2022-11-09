SELECT deptno,
       job,
       AVG(sal)
FROM emp
GROUP BY deptno,job
ORDER BY deptno,job
;
--ORACLE 10G 이전에는 정렬되어서 출력
--ORACLE 10G 이후에는 정렬되지 않음.