SELECT  tt1.rnum,
        tt1.seq,
        tt1.title,
        tt1.mod_id,
        DECODE (TO_CHAR(SYSDATE,'YYYY.MM.DD'),  TO_CHAR(tt1.mod_dt,'YYYYMMDD'),
                                                TO_CHAR(tt1.mod_dt,'HH24:MI'),
                                                TO_CHAR(tt1.mod_dt,'YYYY.MM.DD')) mod_dt,
        tt1.read_cnt
FROM(
    SELECT ROWNUM AS RNUM,t1.*
    FROM(
        SELECT * --인라인 뷰로 사용해서 해야만 가능
        FROM board
        --검색조건
        --WHERE title LIKE '제목_10'||'%'
        --WHERE contents LIKE '내용_100'||'%'
        ORDER BY mod_dt DESC
    )t1
    WHERE ROWNUM <= 10
)tt1
WHERE RNUM >= 1;
