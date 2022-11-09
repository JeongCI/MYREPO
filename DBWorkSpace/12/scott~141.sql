--생성
CREATE OR REPLACE PROCEDURE pro_param_inout
(
    inout_no IN OUT NUMBER
)
IS

BEGIN
    inout_no := inout_no*2;
END;
/
--실행
SET SERVEROUTPUT ON;
DECLARE
    no NUMBER;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    no := 8;
    
    pro_param_inout(no);
    
    DBMS_OUTPUT.PUT_LINE('no : '||no);
END;
/