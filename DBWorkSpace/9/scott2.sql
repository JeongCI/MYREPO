--CRUD
--등록
INSERT INTO board (
    seq,
    title,
    contents,
    reg_id,
    mod_id
) VALUES (
    1000001,
    '99제목',
    '99내용',
    'ADMIN',
    'ADMIN'
);

COMMIT;

--단건조회
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

--수정
UPDATE board
SET
    title = :v1,
    contents = :v2,
    mod_dt = SYSDATE,
    mod_id = :v3
WHERE SEQ = :SEQ
;

--삭제
DELETE FROM board
WHERE seq = :v0;

--조회 COUNT증가
UPDATE board
SET READ_CNT = READ_CNT+1
WHERE seq = :seq
AND mod_id <> (SELECT :mod_id
                 FROM dual)
;