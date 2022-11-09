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
    dept_rec.deptno := 50;
    dept_rec.dname := 'DATABASE_SQL';
    dept_rec.loc := 'CHINCHON';
    
    DBMS_OUTPUT.PUT_LINE('deptno:'||dept_rec.deptno);
    DBMS_OUTPUT.PUT_LINE('dname:'||dept_rec.dname);
    DBMS_OUTPUT.PUT_LINE('loc:'||dept_rec.loc);
    
--    UPDATE DEPT_RECORD
--    SET deptno = dept_rec.deptno
--    WHERE dname = dept_rec.dname;
    
    UPDATE DEPT_RECORD
        SET row = dept_rec
    WHERE deptno = 50;
    commit;
END;
/

SELECT * FROM dept_record;