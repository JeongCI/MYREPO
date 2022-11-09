--10%급여 인상 프로시저 생성
CREATE OR REPLACE PROCEDURE up_sal
(v_empno EMP.empno%TYPE)
IS 
BEGIN
    UPDATE emp_record
    SET sal = SAL*1.1
    WHERE empno = v_empno;
    COMMIT;
END;
/
--실행
EXECUTE up_sal(7788);
--확인
SELECT *
FROM EMP_record
WHERE empno = 7788;