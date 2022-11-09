SELECT deptno,
       LISTAGG(ename,',') WITHIN GROUP (ORDER BY sal ASC) "enames"
FROM emp
GROUP BY deptno
;