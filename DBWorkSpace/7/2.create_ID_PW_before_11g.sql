-- ����� ���� (11g ���� ������� ���� ����)
ALTER SESSION SET "_oracle_script"=true;

-- ������ pcwk / ��� goodman
CREATE USER pcwk
IDENTIFIED BY goodman
DEFAULT TABLESPACE goodman
TEMPORARY TABLESPACE temp;