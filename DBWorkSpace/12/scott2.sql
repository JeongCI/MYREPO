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
        
END;
/