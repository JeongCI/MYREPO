SET SERVEROUTPUT ON;
DECLARE
    V_DEPT dept%ROWTYPE;
    
    CURSOR C1(p_deptno dept.deptno%TYPE)
    IS
    SELECT deptno, dname, loc
    FROM dept
    where deptno = p_deptno;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    
    OPEN C1(10);
    
    LOOP
        
        FETCH C1 INTO V_DEPT;
        
        EXIT WHEN C1%notfound;
        
        DBMS_OUTPUT.PUT_LINE('deptno : '||V_DEPT.deptno||
                             ', dname : '||V_DEPT.dname||
                             ', loc : '||V_DEPT.loc);
        
    END LOOP;
    
    CLOSE C1;
END;
/