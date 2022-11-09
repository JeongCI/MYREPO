SET SERVEROUTPUT ON;
DECLARE
    V_NO number := 0;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    LOOP
        DBMS_OUTPUT.PUT_LINE(V_NO);
        V_NO := V_NO+1;
        IF V_NO > 10 THEN
            EXIT;
        END IF;
    END LOOP;
    
END;
/