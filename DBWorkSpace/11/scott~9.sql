SET SERVEROUTPUT ON;
DECLARE
    V_NO number := 0;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    WHILE V_NO < 5 LOOP
        DBMS_OUTPUT.PUT_LINE(V_NO);
        V_NO := V_NO + 1;
    END LOOP;
END;
/