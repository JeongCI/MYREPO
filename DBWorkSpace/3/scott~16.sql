SELECT empno,
       ename,
       sal,
       comm,
       TO_CHAR((sal*12)+comm, '999,999') "SALARY"
FROM emp
WHERE ename = 'ALLEN'
;