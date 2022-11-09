SET SERVEROUTPUT ON;
DECLARE
    v_wrong DATE;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
    SELECT ename INTO v_wrong
    FROM emp
    WHERE empno =7369;
    
    DBMS_OUTPUT.put_line('예외가 발생하면 다음 문장은 실행되지 않습니다.');
    
    EXCEPTION
        WHEN OTHERS THEN
        DBMS_OUTPUT.put_line('오류가 발생하였습니다.['||TO_CHAR(sysdate,'yyyy"년"MM"월"DD"일" HH24"시"MI"분"SS"초"')||']');
        DBMS_OUTPUT.put_line('SQLCODE :'||SQLCODE);
        DBMS_OUTPUT.put_line('SQLERRM :'||SQLERRM);

END;
/