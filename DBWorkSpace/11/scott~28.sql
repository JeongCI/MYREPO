SET SERVEROUTPUT ON;
DECLARE

BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    UPDATE DEPT_RECORD
    SET dname = 'DATABASE'
    WHERE deptno = 50;
    
    DBMS_OUTPUT.put_line('갱신된 행의 수 : '||SQL%ROWCOUNT);
    
    IF (SQL%FOUND) THEN
        DBMS_OUTPUT.put_line('갱신 대상행 존재 O: TRUE');
    ELSE
        DBMS_OUTPUT.put_line('갱신 대상행 존재 X: FALSE');
    END IF;
    
    IF (SQL%ISOPEN) THEN
        DBMS_OUTPUT.put_line('커서 오픈 여부 : TRUE');
    ELSE
        DBMS_OUTPUT.put_line('커서 오픈 여부 : FALSE');
    END IF;
END;
/

SELECT * FROM DEPT_RECORD;