SELECT ename,
       hiredate,
       sal,
       LAG(sal,3,99) OVER(ORDER BY ename) "LAG"
FROM emp
;