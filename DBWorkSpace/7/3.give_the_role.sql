-- ���ӱ��� �ο�
GRANT CREATE SESSION TO pcwk;

-- ���̺� ����, RESOURCE ���� �ο�
GRANT RESOURCE, CREATE TABLE TO pcwk;

-- tablespace�� ������ insert, update, delete ���� �ο�
ALTER USER pcwk DEFAULT TABLESPACE goodman QUOTA UNLIMITED ON goodman;