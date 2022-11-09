SELECT ename,
       hiredate,
       sal,
       LEAD(sal,2,1) OVER(ORDER BY hiredate) "LEAD"
FROM emp
;