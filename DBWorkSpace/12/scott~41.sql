SET SERVEROUTPUT ON;
DECLARE
    V_WRONG number;
BEGIN
  --  ���ڿ��� ���ڿ� �Ҵ�
  --  DBMS_OUTPUT.PUT_LINE('')
    SELECT dname
    INTO V_WRONG
    FROM dept
    WHERE deptno = 10;
        
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('����ó��: ');
            DBMS_OUTPUT.PUT_LINE('SQLCODE: '||TO_CHAR(SQLCODE));
            DBMS_OUTPUT.PUT_LINE('SQLERRM: '||SQLERRM);
END;
/