SELECT t1.empno,
       t1.ename,
       t2.deptno,
       t2.dname
FROM emp t1, dept t2
WHERE t1.deptno = t2.deptno
;