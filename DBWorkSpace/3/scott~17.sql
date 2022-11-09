SELECT empno,
       ename,
       TO_CHAR(hiredate,'YYYY-MM-DD') "HIREDATE",
       TO_CHAR((sal*12)+comm, '$99,999') "SAL",
       TO_CHAR(((sal*12)+comm)*1.15, '$99,999') "15% UP"
FROM emp
WHERE comm IS NOT null
;