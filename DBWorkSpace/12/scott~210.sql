SET SERVEROUTPUT ON;
DECLARE
    V_WRONG number;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    DBMS_OUTPUT.PUT_LINE('1');
    SELECT 5/0 INTO V_WRONG FROM dual;
--    SELECT dname INTO V_WRONG
--    FROM dept
--    WHERE deptno IN(10);
    DBMS_OUTPUT.PUT_LINE('2');
    
    EXCEPTION
        WHEN ZERO_DIVIDE THEN
            DBMS_OUTPUT.PUT_LINE('����ó��: 0���� ���� �� �����ϴ�.');
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE('����ó��: �䱸���� ���� �� ����! ���� �߻�');
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('����ó��: ���� �Ǵ� �� ���� �߻�');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('����ó��: �׿� ����');
    DBMS_OUTPUT.PUT_LINE('3 ');
END;
/