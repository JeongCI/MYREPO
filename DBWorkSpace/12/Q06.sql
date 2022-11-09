SELECT tablespace_name,
       file_name
FROM dba_data_files;

--tablespace 생성
CREATE TABLESPACE good
DATAFILE 'C:\APP\ITSC\PRODUCT\21C\ORADATA\XE\GOOD.DBF'
SIZE 300M AUTOEXTEND ON next 30M; 
--3. 사용자 생성
--12c 이전 방법으로 계정생성
ALTER SESSION SET "_oracle_script"=true;
--goodman / pcwk
CREATE USER james
IDENTIFIED BY goodman
DEFAULT TABLESPACE good
TEMPORARY TABLESPACE temp;

--접속 권한 부여
GRANT CREATE SESSION TO james;			
--테이블 생성 권한			
GRANT RESOURCE, CREATE TABLE TO james;
--CREATE SYNONYM 권한 부여
GRANT CREATE SYNONYM to james;
--CREATE VIEW 권한 부여
GRANT CREATE VIEW to james;
--default 권한 부여		
ALTER USER james DEFAULT TABLESPACE good QUOTA UNLIMITED ON good;