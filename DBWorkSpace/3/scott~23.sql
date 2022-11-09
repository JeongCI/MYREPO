SELECT empno,
       ename,
       comm,
       NVL2(comm,'0','x') "NVL2",
       NVL2(comm,sal*12+comm,sal*12) "anual_sal"
FROM emp
;