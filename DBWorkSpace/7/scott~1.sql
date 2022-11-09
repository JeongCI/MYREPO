SELECT *
FROM emp
;
SELECT *
FROM dept
;
SELECT *
FROM salgrade
;

SELECT t1.empno,
       t1.ename,
       t2.dname,
       TO_CHAR(t1.hiredate,'YYYY-MM-DD') hiredate,
       t2.loc,
       t1.sal,
       t3.grade
FROM emp t1, dept t2, salgrade t3
WHERE t1.deptno = t2.deptno
AND t1.sal BETWEEN t3.losal AND t3.hisal
AND t1.sal > (SELECT AVG(NVL(sal,0))
              FROM emp)
ORDER BY t1.sal desc, t1.empno asc
;