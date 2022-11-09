CREATE TABLE EMP_RECORD
AS
SELECT * FROM EMP;

SET SERVEROUTPUT ON;
DECLARE
    TYPE REC_EMP IS RECORD(
        empno    EMP.empno%TYPE,
        ename    EMP.ename%TYPE,
        job      EMP.job%TYPE,
        mgr      EMP.mgr%TYPE,
        hiredate EMP.hiredate%TYPE,
        sal      EMP.sal%type,
        comm     EMP.comm%TYPE,
        deptno   EMP.deptno%TYPE
    );
    
    emp_rec REC_EMP;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    emp_rec.empno    := 1111;
    emp_rec.ename    := 'TEST_USER';
    emp_rec.job      := 'TEST_JOB';
    emp_rec.hiredate := '18/03/01';
    emp_rec.comm     := 3000;
    emp_rec.deptno   := 40;
    
    DBMS_OUTPUT.PUT_LINE(emp_rec.empno||emp_rec.ename||emp_rec.job||emp_rec.hiredate
    ||emp_rec.comm||emp_rec.deptno);
    
    INSERT INTO EMP_RECORD
    VALUES emp_rec;
    
END;
/

SELECT *
FROM emp_record;
commit;