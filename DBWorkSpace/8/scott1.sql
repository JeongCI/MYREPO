INSERT INTO emp_temp (
    empno,
    ename,
    job,
    mgr,
    hiredate,
    sal,
    comm,
    deptno
) VALUES (
    9999,
    '�̻�',
    'PRESIDENT',
    NULL,
    '2022-01-01',
    5000,
    1000,
    10
);

SELECT * FROM emp_temp;

INSERT INTO emp_temp (
    empno,
    ename,
    job,
    mgr,
    hiredate,
    sal,
    comm,
    deptno
) VALUES (
    8888,
    'ȫ�浿',
    'PRESIDENT',
    NULL,
    SYSDATE,
    5000,
    1000,
    10
);

SELECT * FROM emp_temp;