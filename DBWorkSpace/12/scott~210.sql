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
            DBMS_OUTPUT.PUT_LINE('예외처리: 0으로 나눌 수 없습니다.');
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE('예외처리: 요구보다 많은 행 추출! 오류 발생');
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('예외처리: 숫자 또는 값 오류 발생');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('예외처리: 그외 에러');
    DBMS_OUTPUT.PUT_LINE('3 ');
END;
/