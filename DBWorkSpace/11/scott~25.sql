SET SERVEROUTPUT ON;
DECLARE
    V_DEPT dept%ROWTYPE;
    
    --Ŀ�� ����
    CURSOR C1 IS
        SELECT deptno, dname, loc
        FROM dept;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    --Ŀ�� OPEN
    OPEN C1;
    
    --FETCH Ŀ���̸� INTO ����;
    LOOP
    
        FETCH C1 INTO V_DEPT;
        
        --LOOP ����
        EXIT WHEN C1%notfound;
        
        DBMS_OUTPUT.PUT_LINE('deptno : '||V_DEPT.deptno);
        DBMS_OUTPUT.PUT_LINE('dname : '||V_DEPT.dname);
        DBMS_OUTPUT.PUT_LINE('loc : '||V_DEPT.loc);
        DBMS_OUTPUT.PUT_LINE('======================================');
    
    END LOOP;
    --CLOSE Ŀ��
    CLOSE C1;
END;
/