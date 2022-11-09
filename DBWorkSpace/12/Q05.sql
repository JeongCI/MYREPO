CREATE OR REPLACE FUNCTION year_sal
(
    v_empno emp.empno%TYPE
)
RETURN NUMBER
IS
    v_sal NUMBER(10);
BEGIN
     SELECT sal
     INTO v_sal
     FROM EMP
     where empno = v_empno;
    
    RETURN v_sal*12;
	
	EXCEPTION
		WHEN ACCESS_INTO_NULL THEN
			DBMS_OUTPUT.PUT_LINE('예외처리');

END;
/

SELECT year_sal(1111)
FROM DUAL
;