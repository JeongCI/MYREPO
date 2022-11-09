--notnull tel 이름 변경
ALTER TABLE notnull
RENAME CONSTRAINT SYS_C008386 TO notnull_tel_nn;

--제약조건 삭제
ALTER TABLE notnull
DROP CONSTRAINT notnull_tel_nn;

DESC notnull;