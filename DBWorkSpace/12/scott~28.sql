SET SERVEROUTPUT ON;
DECLARE

BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    UPDATE DEPT_RECORD
    SET dname = 'DATABASE'
    WHERE deptno = 50;
    
    DBMS_OUTPUT.put_line('���ŵ� ���� �� : '||SQL%ROWCOUNT);
    
    IF (SQL%FOUND) THEN
        DBMS_OUTPUT.put_line('���� ����� ���� O: TRUE');
    ELSE
        DBMS_OUTPUT.put_line('���� ����� ���� X: FALSE');
    END IF;
    
    IF (SQL%ISOPEN) THEN
        DBMS_OUTPUT.put_line('Ŀ�� ���� ���� : TRUE');
    ELSE
        DBMS_OUTPUT.put_line('Ŀ�� ���� ���� : FALSE');
    END IF;
END;
/

SELECT * FROM DEPT_RECORD;