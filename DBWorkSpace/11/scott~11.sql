SET SERVEROUTPUT ON;
DECLARE

BEGIN
  FOR i IN 1.. 10 LOOP
  
    CONTINUE WHEN MOD(i,2) = 1;
    DBMS_OUTPUT.PUT_LINE(i);
    
  END LOOP;

END;
/