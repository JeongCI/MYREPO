CREATE TABLE PC_PRIMARY(
LOGIN_ID VARCHAR2(20) PRIMARY KEY,
LOGIN_PWD VARCHAR2(20) NOT NULL,
TEL VARCHAR2(20)
);
INSERT INTO PC_PRIMARY (
    login_id,
    login_pwd,
    tel
) VALUES (
    'TEST_ID_01',
    '4321',
    '010-1234-5678'
);
INSERT INTO PC_PRIMARY (
    login_id,
    login_pwd,
    tel
) VALUES (
    'TEST_ID_01',
    '4321',
    '010-1234-5678'
);

--제약조건 확인
SELECT owner,
       constraint_name,
       constraint_type,
       table_name
FROM user_constraints
WHERE table_name LIKE '%PC_PRIMARY%';

