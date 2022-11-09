SELECT *
FROM emp_record
WHERE empno = :empid;

UPDATE emp_record
    SET SAL = SAL*1.1
WHERE empno = :empid;

ROLLBACK;