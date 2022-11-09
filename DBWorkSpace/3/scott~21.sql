SELECT ename,
       comm,
       NVL(comm,0),
       NVL(comm,100)
FROM emp
;