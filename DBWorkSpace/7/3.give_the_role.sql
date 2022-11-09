-- 접속권한 부여
GRANT CREATE SESSION TO pcwk;

-- 테이블 생성, RESOURCE 권한 부여
GRANT RESOURCE, CREATE TABLE TO pcwk;

-- tablespace에 데이터 insert, update, delete 권한 부여
ALTER USER pcwk DEFAULT TABLESPACE goodman QUOTA UNLIMITED ON goodman;