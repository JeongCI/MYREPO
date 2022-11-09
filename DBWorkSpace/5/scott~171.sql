SELECT t1.ename "ename", t2.ename "mgr_name"
FROM emp t1,emp t2
WHERE t1.mgr = t2.empno
;

SELECT t1.ename "ename", t2.ename "mgr_name"
FROM emp t1 JOIN emp t2
ON t1.mgr = t2.empno
;