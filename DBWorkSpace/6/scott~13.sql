CREATE TABLE with_test1(
no NUMBER,
name VARCHAR2(10),
pay NUMBER(6)
)
TABLESPACE USERS;


BEGIN
    FOR i IN 1..5000000 LOOP
        INSERT INTO with_test1 VALUES (i,
                                       DBMS_RANDOM.STRING('A',5), --대소문자 구분 없이 영문자 5자리 난수 발생
                                       DBMS_RANDOM.value(6,999999) --숫자 6 자리 난수 발생
                                       );
    END LOOP;
    commit; -- 확정
END;
/

--SQL Developer에서는 전체 조회해도 50건씩 출력됨
--스크롤을 내리면 그 때 50건 씩 추가 출력
--java에 넣고 sql을 실행 시키면 500만 건을 조회 완료 될 때 까지 대기상태 유지
SELECT COUNT(*)
FROM with_test1;