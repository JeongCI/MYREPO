SET SERVEROUTPUT ON;
DECLARE
   v_empno emp.empno%TYPE;
   v_ename emp.ename%TYPE;
   v_deptno emp.deptno%TYPE;
   v_dname VARCHAR2(14);
BEGIN
    SELECT empno, ename, deptno
    INTO v_empno, v_ename, v_deptno
    FROM emp
    WHERE empno = :empid;
    
    v_dname := CASE v_deptno
               WHEN 10 THEN 'ACCOUNTING'
               WHEN 20 THEN 'RESEARCH'
               WHEN 30 THEN 'SALES'
               WHEN 40 THEN 'OPERATIONS'
            END;
    DBMS_OUTPUT.put_line(v_empno||','||v_ename||','||v_deptno||','||v_dname); 
    
END;
/