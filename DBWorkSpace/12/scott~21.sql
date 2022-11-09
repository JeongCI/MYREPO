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
    text_arr(4) := '4th data';
    text_arr(50) := '50th data';
    
    DBMS_OUTPUT.PUT_LINE('text_arr(1) : '||text_arr(1));
    DBMS_OUTPUT.PUT_LINE('text_arr(2) : '||text_arr(2));
    DBMS_OUTPUT.PUT_LINE('text_arr(3) : '||text_arr(3));
    
    DBMS_OUTPUT.PUT_LINE('text_arr.count : '||text_arr.count);
    DBMS_OUTPUT.PUT_LINE('text_arr.FIRST : '||text_arr.FIRST);
    DBMS_OUTPUT.PUT_LINE('text_arr.LAST : '||text_arr.LAST);
    
    DBMS_OUTPUT.PUT_LINE('text_arr.PRIOR(50) : '||text_arr.PRIOR(50));
    DBMS_OUTPUT.PUT_LINE('text_arr.NEXT(50) : '||text_arr.NEXT(50));
END;
/