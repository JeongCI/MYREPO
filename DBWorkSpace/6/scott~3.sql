SELECT *
FROM dept
WHERE EXISTS (SELECT deptno
              FROM dept
              WHERE deptno = &deptno)
;

SELECT *
FROM dept
WHERE deptno IN (SELECT deptno
              FROM dept
              WHERE deptno = &deptno)
;