SELECT t1.empno,
       t1.ename,
       t2.deptno,
       t2.dname
FROM emp t1 INNER JOIN dept t2
ON t1.deptno = t2.deptno
;