SET SERVEROUTPUT ON;
DECLARE
    V_emp emp%ROWTYPE;
        
    CURSOR C1 IS
        SELECT *
        FROM emp;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('') 
   
    FOR V_EMP IN C1 LOOP 
        
        DBMS_OUTPUT.PUT_LINE('EMPNO: '||V_EMP.empno||
                             ', ENAME: '||V_EMP.ename||
                             ', JOB: '||V_EMP.job||
                             ', SAL: '||V_EMP.sal||
                             ', DEPTNO: '||V_EMP.deptno);
    END LOOP;
    
END;
/