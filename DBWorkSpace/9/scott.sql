--notnull tel �̸� ����
ALTER TABLE notnull
RENAME CONSTRAINT SYS_C008386 TO notnull_tel_nn;

--�������� ����
ALTER TABLE notnull
DROP CONSTRAINT notnull_tel_nn;

DESC notnull;