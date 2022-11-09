
select A.*, B.*
FROM (
SELECT ROWNUM as no,
       t1.empno,
       t1.job,
       t1.mgr,
       TO_CHAR(t1.hiredate,'YYYY.MM.DD') HIREDATE,
       TO_CHAR(t1.sal,'$999,999') SAL,
       t1.comm,
       t1.deptno,
       t2.dname,
       t2.loc,
       t3.grade
FROM emp t1 INNER JOIN dept t2
ON t1.deptno = t2.deptno
JOIN salgrade t3
ON t1.sal BETWEEN t3.losal AND t3.hisal
WHERE ROWNUM BETWEEN 1 AND 10) A
NATURAL JOIN
(SELECT COUNT(*)
 FROM EMP)B;