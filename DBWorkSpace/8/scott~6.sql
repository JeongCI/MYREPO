CREATE TABLE board(	
	seq      NUMBER,
	title    VARCHAR2(1000),
	contents CLOB,
	READ_CNT NUMBER        DEFAULT 0,
	REG_ID   VARCHAR2(12),
	REG_DT   DATE          DEFAULT SYSDATE,
    CONSTRAINT PK_BOARD PRIMARY KEY(seq)
);	
COMMENT ON TABLE board is '게시판';	
COMMENT ON column board.seq is '순번';
COMMENT ON column board.title is '제목';
COMMENT ON column board.contents is '내용';
COMMENT ON column board.read_cnt is '읽은 회수';
COMMENT ON column board.reg_id is '등록자ID';
COMMENT ON column board.reg_dt is '등록일';

--board merge
--1, 제목, 내용, pcwk
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