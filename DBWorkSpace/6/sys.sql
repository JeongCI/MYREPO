--sys로 접속
SELECT tablespace_name,
       bytes/(1024*1024) MB,
       file_name
FROM dba_data_files
;

--자동증가
ALTER DATABASE DATAFILE 'C:\APP\ITSC\PRODUCT\21C\ORADATA\XE\USERS01.DBF'
AUTOEXTEND ON;
--Database이(가) 변경되었습니다.