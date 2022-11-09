SELECt t1.*
FROM emp t1
WHERE t1.ename LIKE '%S'
;

SELECT t2.*
FROM emp t2
WHERE t2.deptno = 30
AND t2.job = 'SALESMAN'
;

SELECT t3.empno
       ,t3.ename
       ,t3.job
       ,t3.sal
       ,t3.deptno
FROM emp t3
WHERE t3.deptno BETWEEN 20 AND 30
AND t3.sal > 2000
;

SELECT t4.empno
       ,t4.ename
       ,t4.job
       ,t4.sal
       ,t4.deptno
FROM emp t4
WHERE t4.deptno = 20
AND t4.sal > 2000
UNION ALL
SELECT t4.empno
       ,t4.ename
       ,t4.job
       ,t4.sal
       ,t4.deptno
FROM emp t4
WHERE t4.deptno = 30
AND t4.sal > 2000
;

SELECT *
FROM emp
WHERE not(sal >= 2000 AND sal <= 3000)
;

SELECT ename
       ,empno
       ,sal
       ,deptno
FROM emp
WHERE ename LIKE '%E%'
AND deptno = 30
AND sal NOT BETWEEN 1000 AND 2000
;

SELECT *
FROM emp
WHERE comm IS NULL
AND mgr IS NOT NULL
AND job IN('MANAGER','CLERK')
AND ename NOT LIKE '_L%'
;