--�����Ͱ� 2 row ��½� ����
CREATE TABLE t3(
no NUMBER,
name VARCHAR2(10),
deptno NUMBER
);
INSERT INTO t3 VALUES (1,'AAA',100);
INSERT INTO t3 VALUES (2,'BBB',200);
INSERT INTO t3 VALUES (3,'CCC',300);
COMMIT;

CREATE TABLE t4(
deptno NUMBER,
Dname VARCHAR2(10)
);
INSERT INTO t4 VALUES (1,'DDD');
INSERT INTO t4 VALUES (2,'EEE');
INSERT INTO t4 VALUES (3,'FFF');
INSERT INTO t4 VALUES (4,'GGG');
COMMIT;

SELECT * FROM t3;
SELECT * FROM t4;

SELECT t3.no,
       t3.name,
       (SELECt dname FROM t4 WHERE t3.deptno = t4.deptno) as DNAME
FROM t3
;

--100 -> 400
UPDATE T4
SET deptno = 400
WHERE DNAME = 'EEE'
;
COMMIT;

SELECT t3.no,
       t3.name,
       (SELECt dname FROM t4 WHERE t3.deptno = t4.deptno) as DNAME
FROM t3
;