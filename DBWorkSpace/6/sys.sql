--sys�� ����
SELECT tablespace_name,
       bytes/(1024*1024) MB,
       file_name
FROM dba_data_files
;

--�ڵ�����
ALTER DATABASE DATAFILE 'C:\APP\ITSC\PRODUCT\21C\ORADATA\XE\USERS01.DBF'
AUTOEXTEND ON;
--Database��(��) ����Ǿ����ϴ�.