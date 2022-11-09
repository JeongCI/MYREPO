SELECT t1.job,
       t1.empno,
       t1.ename,
       t1.sal,
       t1.deptno,
       t2.dname
FROM emp t1, dept t2
WHERE t1.deptno = t2.deptno
AND job = (SELECT job
               FROM emp
               WHERE ename = 'ALLEN')
;