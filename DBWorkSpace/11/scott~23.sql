SET SERVEROUTPUT ON;
DECLARE
    TYPE ITAB_EMP IS TABLE OF EMP%ROWTYPE
    INDEX BY PLS_INTEGER;
    
    emp_arr ITAB_EMP;
    idx PLS_INTEGER := 0;
BEGIN
    FOR i IN(SELECT * FROM emp_record) LOOP
        idx := idx+1;
        emp_arr(idx).empno := i.empno;
        emp_arr(idx).ename := i.ename;
        emp_arr(idx).job := i.job;
        emp_arr(idx).mgr := i.mgr;
        emp_arr(idx).hiredate := i.hiredate;
        emp_arr(idx).sal := i.sal;
        emp_arr(idx).comm := i.comm;
        emp_arr(idx).deptno := i.deptno;
                
        DBMS_OUTPUT.PUT_LINE(idx||':'||emp_arr(idx).empno||':'||emp_arr(idx).ename||':'||
        emp_arr(idx).job||':'||emp_arr(idx).mgr||':'||emp_arr(idx).hiredate||':'||
        emp_arr(idx).sal||':'||emp_arr(idx).comm||':'||emp_arr(idx).deptno);
    
    END LOOP;
    
END;
/