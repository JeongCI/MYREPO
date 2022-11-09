SELECT empno,
       ename,
       job,
       sal
FROM emp
WHERE deptno = 10;

--������ 3�� ���
SELECT level c1
FROM dual
CONNECT BY level <= 3
;

SELECT empno,
       ename,
       job,
       sal
FROM emp
WHERE deptno = 10;

SELECT *
FROM (
        SELECT empno,
               ename,
               job,
               sal
        FROM emp
        WHERE deptno = 10), (SELECT level c1
                             FROM dual
                             CONNECT BY level <= 3)
;                             