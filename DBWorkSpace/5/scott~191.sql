SELECT *
FROM emp
;

SELECT *
FROM dept
;

SELECT t1.deptno,
       t2.dname,
       TRUNC(AVG(t1.sal)),
       MAX(t1.sal),
       MIN(t1.sal),
       COUNT(t1.sal)
FROM emp t1, dept t2
WHERE t1.deptno = t2.deptno
GROUP BY t1.deptno,t2.dname
ORDER BY deptno
;

SELECT t1.deptno,
       t2.dname,
       TRUNC(AVG(t1.sal)),
       MAX(t1.sal),
       MIN(t1.sal),
       COUNT(t1.sal)
FROM emp t1 INNER JOIN dept t2
ON t1.deptno = t2.deptno
GROUP BY t1.deptno,t2.dname
ORDER BY deptno
;