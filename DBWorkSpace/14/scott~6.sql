--테이블 생성
CREATE TABLE T_IDEN(
    NO NUMBER GENERATED AS IDENTITY,
    NAME VARCHAR2(20)
);
-- 데이터 삽입
INSERT INTO T_IDEN(NAME) VALUES('K');
INSERT INTO T_IDEN(NAME) VALUES('C');
INSERT INTO T_IDEN(NAME) VALUES('W');

SELECT * FROM T_IDEN;