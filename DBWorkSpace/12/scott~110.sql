SET SERVEROUTPUT ON;
DECLARE
    V_WRONG number;
BEGIN
  --  문자열을 숫자에 할당
  --  DBMS_OUTPUT.PUT_LINE('')
  DBMS_OUTPUT.PUT_LINE('1');
        SELECT dname
        INTO V_WRONG
        FROM dept
        WHERE deptno = 10;
        DBMS_OUTPUT.PUT_LINE('2');
    EXCEPTION
     WHEN VALUE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('예외처리:수치 또는 값 오류 발생');
        DBMS_OUTPUT.PUT_LINE('3');
        
    DBMS_OUTPUT.PUT_LINE('4');
END;
/