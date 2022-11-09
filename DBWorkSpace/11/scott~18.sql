SET SERVEROUTPUT ON;
DECLARE
    TYPE ITAB_EX IS TABLE OF VARCHAR2(20)
    INDEX BY PLS_INTEGER;
    
    text_arr ITAB_EX;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    text_arr(1) := '1st data';
    text_arr(2) := '2nd data';
    text_arr(3) := '3rd data';
    
    DBMS_OUTPUT.PUT_LINE('text_arr(1) : '||text_arr(1));
    DBMS_OUTPUT.PUT_LINE('text_arr(2) : '||text_arr(2));
    DBMS_OUTPUT.PUT_LINE('text_arr(3) : '||text_arr(3));
END;
/