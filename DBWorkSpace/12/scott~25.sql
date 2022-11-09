SET SERVEROUTPUT ON;
DECLARE
    V_DEPT dept%ROWTYPE;
    
    --커서 선언
    CURSOR C1 IS
        SELECT deptno, dname, loc
        FROM dept;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    --커서 OPEN
    OPEN C1;
    
    --FETCH 커서이름 INTO 변수;
    LOOP
    
        FETCH C1 INTO V_DEPT;
        
        --LOOP 종료
        EXIT WHEN C1%notfound;
        
        DBMS_OUTPUT.PUT_LINE('deptno : '||V_DEPT.deptno);
        DBMS_OUTPUT.PUT_LINE('dname : '||V_DEPT.dname);
        DBMS_OUTPUT.PUT_LINE('loc : '||V_DEPT.loc);
        DBMS_OUTPUT.PUT_LINE('======================================');
    
    END LOOP;
    --CLOSE 커서
    CLOSE C1;
END;
/