SELECT deptno,
       job,
       AVG(sal)
FROM emp
GROUP BY deptno,job
ORDER BY deptno,job
;
--ORACLE 10G �������� ���ĵǾ ���
--ORACLE 10G ���Ŀ��� ���ĵ��� ����.