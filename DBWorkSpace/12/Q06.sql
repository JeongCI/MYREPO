SELECT tablespace_name,
       file_name
FROM dba_data_files;

--tablespace ����
CREATE TABLESPACE good
DATAFILE 'C:\APP\ITSC\PRODUCT\21C\ORADATA\XE\GOOD.DBF'
SIZE 300M AUTOEXTEND ON next 30M; 
--3. ����� ����
--12c ���� ������� ��������
ALTER SESSION SET "_oracle_script"=true;
--goodman / pcwk
CREATE USER james
IDENTIFIED BY goodman
DEFAULT TABLESPACE good
TEMPORARY TABLESPACE temp;

--���� ���� �ο�
GRANT CREATE SESSION TO james;			
--���̺� ���� ����			
GRANT RESOURCE, CREATE TABLE TO james;
--CREATE SYNONYM ���� �ο�
GRANT CREATE SYNONYM to james;
--CREATE VIEW ���� �ο�
GRANT CREATE VIEW to james;
--default ���� �ο�		
ALTER USER james DEFAULT TABLESPACE good QUOTA UNLIMITED ON good;