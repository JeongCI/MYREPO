SET SERVEROUTPUT ON;
DECLARE
   v_empno emp.empno%TYPE;
   v_ename emp.ename%TYPE;
   v_comm emp.comm%TYPE;
   v_total NUMBER;
BEGIN
    SELECT empno, ename, comm, (sal*12)+comm
    INTO v_empno, v_ename, v_comm, v_total
    FROM emp
    WHERE empno = &empid;
    
    DBMS_OUTPUT.put_line(v_empno||','||v_ename||','||v_comm);   
    
    IF v_comm > 0 THEN
        DBMS_OUTPUT.put_line(v_ename||'�� ������ $'||v_total||'�Դϴ�.'); 
    ELSE
        DBMS_OUTPUT.put_line(v_ename||' ����� ���ʽ��� �����ϴ�'); 
    END IF;

END;
/