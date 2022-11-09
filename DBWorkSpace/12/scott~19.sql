SET SERVEROUTPUT ON;
DECLARE
    --RECORD
    TYPE REC_DEPT IS RECORD (
        deptno DEPT.DEPTNO%TYPE,
        dname DEPT.DNAME%TYPE
    );
    TYPE ITAB_DEPT IS TABLE OF REC_DEPT
    INDEX BY PLS_INTEGER;
    
    dept_arr ITAB_DEPT;
    idx PLS_INTEGER := 0;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    FOR i IN (SELECT * FROM DEPT) LOOP
        idx := idx+1;
        dept_arr(idx).deptno := i.deptno;
        dept_arr(idx).dname := i.dname;
        
        DBMS_OUTPUT.PUT_LINE(idx||'.'||dept_arr(idx).deptno||','||dept_arr(idx).dname);
    END LOOP;
    
END;
/