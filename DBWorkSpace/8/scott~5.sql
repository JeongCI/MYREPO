CREATE TABLE charge01 (			
	u_date varchar2 (6),		
	cust_no NUMBER,		
	u_time NUMBER,		
	change NUMBER		
);

CREATE TABLE charge02 (			
	u_date varchar2 (6),		
	cust_no NUMBER,		
	u_time NUMBER,		
	change NUMBER		
);

INSERT INTO charge01 (
    u_date,
    cust_no,
    u_time,
    change
) VALUES (
    '141001',
    1000,
    2,
    1000
);
INSERT INTO charge01 (
    u_date,
    cust_no,
    u_time,
    change
) VALUES (
    '141001',
    1001,
    2,
    1000
);
INSERT INTO charge01 (
    u_date,
    cust_no,
    u_time,
    change
) VALUES (
    '141001',
    1002,
    1,
    500
);

SELECT * FROM charge01;

INSERT INTO charge02 (
    u_date,
    cust_no,
    u_time,
    change
) VALUES (
    '141002',
    1000,
    3,
    1500
);
INSERT INTO charge02 (
    u_date,
    cust_no,
    u_time,
    change
) VALUES (
    '141002',
    1001,
    4,
    2000
);
INSERT INTO charge02 (
    u_date,
    cust_no,
    u_time,
    change
) VALUES (
    '141002',
    1003,
    1,
    500
);
SELECT * FROM charge02;
commit;

CREATE TABLE CH_TOTAL
AS
SELECT * FROM charge01
WHERE 1<>1;

SELECT * FROM CH_TOTAL;

--charge01을 ch_total에 MERGE
MERGE INTO CH_TOTAL t1
USING charge01 t2
ON (t1.U_DATE = t2.U_DATE)
WHEN MATCHED THEN
    UPDATE SET t1.cust_no = t2.cust_no
WHEn NOT MATCHED THEN
    INSERT VALUES (t2.u_date,t2.cust_no,t2.u_time,t2.change)
;
SELECT * FROM CH_TOTAL;

--charge02를 ch_total에 merge
--char01을 ch_total에 MERGE
MERGE INTO CH_TOTAL t1
USING charge02 t2
ON (t1.U_DATE = t2.U_DATE)
WHEN MATCHED THEN
    UPDATE SET t1.cust_no = t2.cust_no
WHEn NOT MATCHED THEN
    INSERT VALUES (t2.u_date,t2.cust_no,t2.u_time,t2.change)
;
SELECT * FROM CH_TOTAL;