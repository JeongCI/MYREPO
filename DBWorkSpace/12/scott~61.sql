SET SERVEROUTPUT ON;
DECLARE
    v_wrong DATE;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    SELECT ename INTO v_wrong
    FROM emp
    WHERE empno =7369;
    
    DBMS_OUTPUT.put_line('���ܰ� �߻��ϸ� ���� ������ ������� �ʽ��ϴ�.');
    
    EXCEPTION
        WHEN OTHERS THEN
        DBMS_OUTPUT.put_line('������ �߻��Ͽ����ϴ�.['||TO_CHAR(sysdate,'yyyy"��"MM"��"DD"��" HH24"��"MI"��"SS"��"')||']');
        DBMS_OUTPUT.put_line('SQLCODE :'||SQLCODE);
        DBMS_OUTPUT.put_line('SQLERRM :'||SQLERRM);

END;
/