CREATE OR REPLACE FUNCTION fun_sal   
(   
   v_empno IN emp.empno%TYPE
)   
RETURN VARCHAR2
IS 
   v_sal NUMBER;
    v_count number := 0;
BEGIN   
    SELECT COUNT (*)
    INTO v_count
    FROM emp
    WHERE empno=v_empno;
    
    IF(v_count =0) THEN
        DBMS_OUTPUT.PUT_LINE( '해당사번의 사원이 없습니다.');
    ELSE
        SELECT sal*12 sal
        INTO v_sal
        FROM emp
        WHERE sal=v_sal;
    DBMS_OUTPUT.PUT_LINE('v_empno'||v_empno);
    DBMS_OUTPUT.PUT_LINE('v_sal'||v_sal);
    END IF;
     RETURN v_sal;
END;
/