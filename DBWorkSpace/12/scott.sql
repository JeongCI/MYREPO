SELECT *
FROM emp
WHERE empno LIKE '%'||?||'%' OR deptno LIKE '%'||?||'%'; 