-- 프로시저 생성
CREATE OR REPLACE PROCEDURE pro_param_in
(
    param01 IN NUMBER,
    param02 NUMBER,    --MODE 생략하면 DEFAULT IN
    param03 NUMBER := 3,
    param04 IN NUMBER DEFAULT 4
)
IS

BEGIN
    DBMS_OUTPUT.PUT_LINE('param01: '||param01 );
    DBMS_OUTPUT.PUT_LINE('param02: '||param02 );
    DBMS_OUTPUT.PUT_LINE('param03: '||param03 );
    DBMS_OUTPUT.PUT_LINE('param04: '||param04 );
END;
/

-- 파람 전달 : 4 (전달 완료)
EXECUTE pro_param_in(1,2,8,9);
-- 파람 전달 : 2 (전달 완료)
EXECUTE pro_param_in(1,2);
-- 파람 전달 : 1 (오류 발생)
EXECUTE pro_param_in(1);