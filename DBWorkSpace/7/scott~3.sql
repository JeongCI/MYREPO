SELECT t1.empno,
       t1.ename,
       t1.sal,
       t3.grade
FROM emp t1, dept t2, salgrade t3
WHERE t1.deptno = t2.deptno
AND t1.sal BETWEEN t3.losal AND t3.hisal
AND t1.sal >all(SELECT sal
                FROM emp
                WHERE job = 'SALESMAN')
;