SET SERVEROUTPUT ON;
DECLARE
    V_DEPT dept%ROWTYPE;
    
    --커서 선언
    CURSOR C1 IS
        SELECT deptno, dname, loc
        FROM dept
        WHERE deptno = 40;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    --커서오픈
    OPEN C1;
    
    --FETCH 커서이름 INTO 변수;
    FETCH C1 INTO V_DEPT;
        
        DBMS_OUTPUT.PUT_LINE('deptno : '||V_DEPT.deptno);
        DBMS_OUTPUT.PUT_LINE('dname : '||V_DEPT.dname);
        DBMS_OUTPUT.PUT_LINE('loc : '||V_DEPT.loc);
    
    CLOSE C1;
END;
/