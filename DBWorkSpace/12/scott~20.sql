SET SERVEROUTPUT ON;
DECLARE
    TYPE ITAB_DEPT IS TABLE OF dept%ROWTYPE
    INDEX BY PLS_INTEGER;
    
    dept_arr ITAB_DEPT;
    idx PLS_INTEGER := 0;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    FOR i IN (SELECT * FROM DEPT) LOOP
        idx := idx+1;
        dept_arr(idx).deptno := i.deptno;
        dept_arr(idx).dname := i.dname;
        dept_arr(idx).loc := i.loc;
        
        DBMS_OUTPUT.PUT_LINE(idx||'.'||dept_arr(idx).deptno||','||dept_arr(idx).dname
        ||','||dept_arr(idx).loc);
    END LOOP;
END;
/