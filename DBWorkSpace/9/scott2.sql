--CRUD
--���
INSERT INTO board (
    seq,
    title,
    contents,
    reg_id,
    mod_id
) VALUES (
    1000001,
    '99����',
    '99����',
    'ADMIN',
    'ADMIN'
);

COMMIT;

--�ܰ���ȸ
SELECT
    seq,
    title,
    contents,
    TO_CHAR(read_cnt,'999,999') read_cnt,
    TO_CHAR(mod_dt,'YYYY.MM.DD HH24:MI:SS') mod_dt,
    mod_id
FROM board
WHERE seq = &seq
;

--����
UPDATE board
SET
    title = :v1,
    contents = :v2,
    mod_dt = SYSDATE,
    mod_id = :v3
WHERE SEQ = :SEQ
;

--����
DELETE FROM board
WHERE seq = :v0;

--��ȸ COUNT����
UPDATE board
SET READ_CNT = READ_CNT+1
WHERE seq = :seq
AND mod_id <> (SELECT :mod_id
                 FROM dual)
;