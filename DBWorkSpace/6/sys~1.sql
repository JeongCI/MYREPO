--goodman_ts.dbf
--1. tablespace ���� Ȯ��
SELECT tablespace_name,
       file_name
FROM dba_data_files
;

--2. tablespace ����
CREATE TABLESPACE goodman_ts
DATAFILE 'C:\APP\ITSC\PRODUCT\21C\ORADATA\XE\goodman01.DBF'
SIZE 200M AUTOEXTEND ON next 20M; 

--3. ����� ����
--12c ���� ������� ��������
ALTER SESSION SET "_oracle_script"=true;

--goodman / pcwk
CREATE USER goodman
IDENTIFIED BY pcwk
DEFAULT TABLESPACE GOODMAN_TS
TEMPORARY TABLESPACE temp;

--4. ���Ѻο�
--4.1. ���ӱ��� �ο�
GRANT CREATE SESSION TO goodman;

--4.2. ���̺� ��������
GRANT RESOURCE, CREATE TABLE TO goodman;

--4.3 tablespace�� ������ insert, delete ���� �ο�
ALTER USER goodman DEFAULT TABLESPACE goodman_ts QUOTA UNLIMITED ON goodman_ts;

--���� ���
REVOKE RESOURCE, CREATE TABLE FROM goodman;