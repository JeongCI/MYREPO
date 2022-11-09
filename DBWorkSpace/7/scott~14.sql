INSERT INTO emp_hw
SELECT
    empno,
    ename,
    job,
    mgr,
    hiredate,
    sal,
    comm,
    deptno,
    null remark
FROM emp;
COMMIT;

SELECT * FROM emp_hw;