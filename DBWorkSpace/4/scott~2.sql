SELECT empno,
       REPLACE(empno,SUBSTR(empno,3),'**') "MASKING_EMPNO",
       ename,
       REPLACE(ename,SUBSTR(ename,2),'****') "MASKING_ENAME"
FROM emp
WHERE LENGTH(ename) = 5
;

SELECT empno,
       ename,
       sal,
       TRUNC((sal/21.5),2) "DAY_PAY",
       ROUND((sal/21.5)/8,1) "TIME_PAY"
FROM emp
;

SELECT empno,
       ename,
       hiredate,
       TO_CHAR(NEXT_DAY(ADD_MONTHS(hiredate,3),'¿ù'),'YYYY-MM-DD') "R_JOB",
       NVL2(comm,TO_CHAR(comm),'N/A') "COMM"
FROM emp
;

SELECT empno,
       ename,
       mgr,
       CASE WHEN SUBSTR(mgr,1,2) IS NULL THEN '0000'
            WHEN SUBSTR(mgr,1,2) = '75' THEN '5555'
            WHEN SUBSTR(mgr,1,2) = '76' THEN '6666'
            WHEN SUBSTR(mgr,1,2) = '77' THEN '7777'
            WHEN SUBSTR(mgr,1,2) = '78' THEN '8888'
                                        ELSE TO_CHAR(mgr)
        END "CHG_MGR"
FROM emp
;