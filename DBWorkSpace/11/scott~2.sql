SET SERVEROUTPUT ON;
DECLARE
    V_SCORE NUMBER := 88;
BEGIN
      CASE TRUNC(V_SCORE/10) 			
        WHEN 10 THEN		
            DBMS_OUTPUT.PUT_LINE('A학점');	
        WHEN 9 THEN		
            DBMS_OUTPUT.PUT_LINE('B학점');
        WHEN 8 THEN		
            DBMS_OUTPUT.PUT_LINE('C학점');
        WHEN 7 THEN		
            DBMS_OUTPUT.PUT_LINE('D학점');
        ELSE		
            DBMS_OUTPUT.PUT_LINE('F학점');
    END CASE;		
END;
/