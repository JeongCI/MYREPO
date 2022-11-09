SET SERVEROUTPUT ON;
DECLARE
    TYPE REC_DEPT IS RECORD(
        deptno NUMBER(2) NOT NULL := 99,
        dname DEPT.DNAME%TYPE,
        loc DEPT.LOC%TYPE
    );
    --변수선언
    dept_rec REC_DEPT;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    SELECT deptno, dname, loc
    INTO dept_rec
    FROM dept
    WHERE deptno = &deptno;
    
    DBMS_OUTPUT.PUT_LINE('deptno:'||dept_rec.deptno);
    DBMS_OUTPUT.PUT_LINE('dname:'||dept_rec.dname);
    DBMS_OUTPUT.PUT_LINE('loc:'||dept_rec.loc);
END;
/