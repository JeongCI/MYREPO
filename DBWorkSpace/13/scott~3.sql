--STEP 1. CTAS EMP -> EMP_TRIGGER
CREATE TABLE EMP_TRIGGER
AS
SELECT * FROM EMP;

--STEP 2. 트리거 생성
CREATE OR REPLACE TRIGGER trg_emp_nodml_weekend
BEFORE

INSERT OR UPDATE OR DELETE ON emp_trigger

BEGIN
    IF TO_CHAR(SYSDATE,'DY') IN('토','일') THEN
    
        IF INSERTING THEN
            RAISE_APPLICATION_ERROR(-20000,'주말 사원 정보 추가 불가');
        ELSIF UPDATING THEN 
            RAISE_APPLICATION_ERROR(-20001,'주말 사원 정보 수정 불가');
        ELSIF DELETING THEN
            RAISE_APPLICATION_ERROR(-20002,'주말 사원 정보 삭제 불가');
        ELSE
            RAISE_APPLICATION_ERROR(-20003,'주말 사원 정보 변경 불가');
        END IF;
    END IF;
END;
/

-- STEP 3. 확인
UPDATE emp_trigger
SET sal = 24500
WHERE empno = 7788;

SELECT *
FROM EMP_TRIGGER
WHERE empno = 7788;