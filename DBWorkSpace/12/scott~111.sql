--10%�޿� �λ� ���ν��� ����
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
--����
EXECUTE up_sal(7788);
--Ȯ��
SELECT *
FROM EMP_record
WHERE empno = 7788;