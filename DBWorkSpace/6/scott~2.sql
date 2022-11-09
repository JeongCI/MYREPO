SELECT empno,
       ename,
       job,
       sal,
       deptno
FROM emp
WHERE sal IN(SELECT MAX(sal)
             FROM emp
             GROUP BY deptno)
;
