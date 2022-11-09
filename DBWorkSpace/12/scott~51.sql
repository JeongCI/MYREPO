SET SERVEROUTPUT ON;
DECLARE
    V_emp emp%ROWTYPE;
    
    CURSOR C1 IS
        SELECT *
        FROM emp;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
  
    OPEN C1;
    
   
    LOOP 
        FETCH C1 INTO V_emp;
         
        EXIT WHEN C1%notfound;
        
        DBMS_OUTPUT.PUT_LINE('EMPNO: '||V_EMP.empno||
                             ', ENAME: '||V_EMP.ename||
                             ', JOB: '||V_EMP.job||
                             ', SAL: '||V_EMP.sal||
                             ', DEPTNO: '||V_EMP.deptno);
    END LOOP;
    
    CLOSE C1;

END;
/