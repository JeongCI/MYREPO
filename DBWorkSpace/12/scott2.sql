SET SERVEROUTPUT ON;
DECLARE
    V_WRONG number;
BEGIN
  --  문자열을 숫자에 할당
  --  DBMS_OUTPUT.PUT_LINE('')
    SELECT dname
    INTO V_WRONG
    FROM dept
    WHERE deptno = 10;
        
END;
/