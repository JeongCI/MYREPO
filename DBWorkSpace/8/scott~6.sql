CREATE TABLE board(	
	seq      NUMBER,
	title    VARCHAR2(1000),
	contents CLOB,
	READ_CNT NUMBER        DEFAULT 0,
	REG_ID   VARCHAR2(12),
	REG_DT   DATE          DEFAULT SYSDATE,
    CONSTRAINT PK_BOARD PRIMARY KEY(seq)
);	
COMMENT ON TABLE board is '�Խ���';	
COMMENT ON column board.seq is '����';
COMMENT ON column board.title is '����';
COMMENT ON column board.contents is '����';
COMMENT ON column board.read_cnt is '���� ȸ��';
COMMENT ON column board.reg_id is '�����ID';
COMMENT ON column board.reg_dt is '�����';

--board merge
--1, ����, ����, pcwk
MERGE INTO board t1
USING ( SELECT :seq as seq,
               :title as title,
               :contents as contents,
               :reg_id as reg_id
        FROM dual
) t2
ON (t1.seq = t2.seq)
WHEN MATCHED THEN
    UPDATE SET t1.title = t2.title,
               t1.contents = t2.contents,
               t1.reg_id = t2.reg_id,
               t1.reg_dt = sysdate
WHEN NOT MATCHED THEN
    INSERT (t1.seq,t1.title,t1.contents,t1.reg_id)
    VALUES (t2.seq,t2.title,t2.contents,t2.reg_id)
;

SELECT * FROM board;