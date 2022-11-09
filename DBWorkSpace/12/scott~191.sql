-- 테이블 생성
CREATE TABLE members
(
ID VARCHAR2(10),
AGE NUMBER(2)
);
insert INTO members VALUES ('sports',35);
insert INTO members VALUES ('admin',40);
insert INTO members VALUES ('brown',20);
-- 프로시저 생성

SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE USER_PROC
AS
    var_age NUMBER;
BEGIN
    SELECT AGE INTO var_age
    FROM MEMBERS
    WHERE ID = 'admin';
    
    IF var_age >= 40 THEN
        var_age := var_age + 1;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(var_age);

END;
-- 실행
SET SERVEROUTPUT ON;
    EXECUTE USER_PROC;