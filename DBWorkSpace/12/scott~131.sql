-- 프로시저 생성
CREATE OR REPLACE PROCEDURE pro_param_in
(
    in_empno IN emp.empno%TYPE,
    out_ename OUT emp.ename%TYPE,
    out_sal  OUT emp.sal%TYPE
)
IS

BEGIN
    SELECT ename, sal
    INTO out_ename, out_sal
    FROM emp_record
    WHERE empno = in_empno;
END;
/

-- 실행 및 확인
SET SERVEROUTPUT ON;
DECLARE
    V_ENAME emp.ename%TYPE;
    V_SAL emp.sal%TYPE;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    pro_param_in(7788,V_ENAME,V_SAL);
    DBMS_OUTPUT.put_line('V_ENAME : '||V_ENAME);
    DBMS_OUTPUT.put_line('V_SAL : '||V_SAL);
END;
/