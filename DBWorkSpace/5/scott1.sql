CREATE TABLE cat_a ( no NUMBER, name VARCHAR2(1) );
INSERT INTO cat_a VALUES (1,'A');
INSERT INTO cat_a VALUES (2,'B');
COMMIT;

CREATE TABLE cat_b ( no NUMBER, name VARCHAR2(1) );
INSERT INTO cat_b VALUES (1,'C');
INSERT INTO cat_b VALUES (2,'D');
COMMIT;

CREATE TABLE cat_c ( no NUMBER, name VARCHAR2(1) );
INSERT INTO cat_c VALUES (1,'E');
INSERT INTO cat_c VALUES (2,'F');
COMMIT;