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

--1. �μ���, job�� �Ұ�
--2. ���޺� �Ұ�
--3. �μŹ� �Ұ�
--4. ��ü �Ұ�