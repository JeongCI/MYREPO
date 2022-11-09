SELECT deptno, job, AVG(NVL(sal,0)), COUNT(*) "CNT_EMP"
FROM emp
GROUP BY deptno, job
UNION ALL
SELECT deptno, NULL as job, AVG(NVL(sal,0)), COUNT(*) "CNT_EMP"
FROM emp
GROUP BY deptno
UNION ALL
SELECT NULL as deptno, job, AVG(NVL(sal,0)), COUNT(*) "CNT_EMP"
FROM emp
GROUP BY job
UNION ALL
SELECT NULL as deptno, NULL as job, AVG(NVL(sal,0)), COUNT(*) "CNT_EMP"
FROM emp
ORDER BY deptno, job
;

--1. 부서별, job별 소계
--2. 직급별 소계
--3. 부셔벌 소계
--4. 전체 소계