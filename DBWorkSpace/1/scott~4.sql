SELECT t1.empno,
       t1.ename,
       t1.sal
FROM emp t1
WHERE t1.empno = &empno
;