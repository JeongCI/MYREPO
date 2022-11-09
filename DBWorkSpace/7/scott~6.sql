--emp를 ctas로생성(emp테이블은 다시써야하니까 같은 데이터 구조 테이블만듬)
CREATE TABLE emp_alter
AS
SELECT *
FROM emp;
--테이블 확인
SELECT
    * FROM emp_alter;
--ADD 테이블에 열추가 = 컬럼추가(열추가)
--HP  VARCHAR2(13 BYTE) 컬럼추가
ALTER TABLE emp_alter
ADD HP VARCHAR2 (13 BYTE);