--goodman_ts.dbf
--1. tablespace 정보 확인
SELECT tablespace_name,
       file_name
FROM dba_data_files
;

--2. tablespace 생성
CREATE TABLESPACE goodman_ts
DATAFILE 'C:\APP\ITSC\PRODUCT\21C\ORADATA\XE\goodman01.DBF'
SIZE 200M AUTOEXTEND ON next 20M; 

--3. 사용자 생성
--12c 이전 방법으로 계정생성
ALTER SESSION SET "_oracle_script"=true;

--goodman / pcwk
CREATE USER goodman
IDENTIFIED BY pcwk
DEFAULT TABLESPACE GOODMAN_TS
TEMPORARY TABLESPACE temp;

--4. 권한부여
--4.1. 접속권한 부여
GRANT CREATE SESSION TO goodman;

--4.2. 테이블 생성권한
GRANT RESOURCE, CREATE TABLE TO goodman;

--4.3 tablespace에 데이터 insert, delete 권한 부여
ALTER USER goodman DEFAULT TABLESPACE goodman_ts QUOTA UNLIMITED ON goodman_ts;

--권한 취소
REVOKE RESOURCE, CREATE TABLE FROM goodman;