--STEP 1. CTAS EMP -> EMP_TRIGGER
CREATE TABLE EMP_TRIGGER
AS
SELECT * FROM EMP;

--STEP 2. Ʈ���� ����
CREATE OR REPLACE TRIGGER trg_emp_nodml_weekend
BEFORE

INSERT OR UPDATE OR DELETE ON emp_trigger

BEGIN
    IF TO_CHAR(SYSDATE,'DY') IN('��','��') THEN
    
        IF INSERTING THEN
            RAISE_APPLICATION_ERROR(-20000,'�ָ� ��� ���� �߰� �Ұ�');
        ELSIF UPDATING THEN 
            RAISE_APPLICATION_ERROR(-20001,'�ָ� ��� ���� ���� �Ұ�');
        ELSIF DELETING THEN
            RAISE_APPLICATION_ERROR(-20002,'�ָ� ��� ���� ���� �Ұ�');
        ELSE
            RAISE_APPLICATION_ERROR(-20003,'�ָ� ��� ���� ���� �Ұ�');
        END IF;
    END IF;
END;
/

-- STEP 3. Ȯ��
UPDATE emp_trigger
SET sal = 24500
WHERE empno = 7788;

SELECT *
FROM EMP_TRIGGER
WHERE empno = 7788;