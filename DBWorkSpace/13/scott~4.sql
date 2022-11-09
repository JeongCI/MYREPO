-- ����
CREATE OR REPLACE PROCEDURE pro_dept_in
(
    INOUT_DEPTNO IN OUT DEPT.DEPTNO%TYPE,
    OUT_DNAME OUT DEPT.DNAME%TYPE,
    OUT_LOC OUT DEPT.LOC%TYPE
)
IS
BEGIN
    SELECT DEPTNO, DNAME, LOC
    INTO INOUT_DEPTNO, OUT_DNAME, OUT_LOC
    FROM DEPT
    WHERE DEPTNO = INOUT_DEPTNO;
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('����ó��: ��ȸ ������ ����!');
            DBMS_OUTPUT.PUT_LINE('SQLCODE: '||TO_CHAR(SQLCODE));
            DBMS_OUTPUT.PUT_LINE('SQLERRM: '||SQLERRM);
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE('����ó��: �䱸���� ���� �� ���� ���� �߻�!');
            DBMS_OUTPUT.PUT_LINE('SQLCODE: '||TO_CHAR(SQLCODE));
            DBMS_OUTPUT.PUT_LINE('SQLERRM: '||SQLERRM);
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('����ó��: ��ġ �Ǵ� �� ���� �߻�!');
            DBMS_OUTPUT.PUT_LINE('SQLCODE: '||TO_CHAR(SQLCODE));
            DBMS_OUTPUT.PUT_LINE('SQLERRM: '||SQLERRM);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('����ó��: ���� ���� �� ���� �߻�!');
            DBMS_OUTPUT.PUT_LINE('SQLCODE: '||TO_CHAR(SQLCODE));
            DBMS_OUTPUT.PUT_LINE('SQLERRM: '||SQLERRM);
END;
/
-- Ȯ��
SET SERVEROUTPUT ON;
DECLARE
    V_DEPTNO dept.deptno%TYPE;
    V_DNAME dept.dname%TYPE;
    V_LOC dept.loc%TYPE;
BEGIN
    V_DEPTNO := 10;
    pro_dept_in(V_DEPTNO,V_DNAME,V_LOC);
    DBMS_OUTPUT.put_line('�μ���ȣ: '||V_DEPTNO);
    DBMS_OUTPUT.put_line('�μ��̸�: '||V_DNAME);
    DBMS_OUTPUT.put_line('����: '||V_LOC);
END;