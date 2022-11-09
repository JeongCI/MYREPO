-- 생성
CREATE OR REPLACE FUNCTION get_deptno
(
    v_deptno dept.deptno%TYPE
)
RETURN VARCHAR2
IS
    v_dname VARCHAR2(100);
    v_count number := 0;
BEGIN
    SELECT COUNT(*)
    into v_count
    FROM dept
    WHERE deptno = v_deptno;
    
    IF v_count = 0 THEN
        v_dname := '해당부서가 없습니다.!';
    ELSE
        SELECT dname
        INTO v_dname
        FROM dept
        WHERE deptno = v_deptno;
    END IF;
    
    RETURN v_dname;

END;
/
-- 실행
SELECT GET_DEPTNO(60)
FROM DUAL
;