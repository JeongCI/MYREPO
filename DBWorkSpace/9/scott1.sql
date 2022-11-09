SELECT tt1.RNUM,
       tt1.seq,
       tt1.title,
       tt1.mod_id,
       DECODE(TO_CHAR(sysdate,'YYYYMMDD'), TO_CHAR(tt1.mod_dt,'YYYYMMDD')
                                         , TO_CHAR(tt1.mod_dt,'HH24:MI')
                                         , TO_CHAR(tt1.mod_dt,'YYYY.MM.DD')) mod_dt,
       tt1.read_cnt
FROM(
    SELECT rownum as Rnum,t1.*
    FROM(
        SELECT *
        FROM board
        ORDER BY mod_dt desc
    )t1
)tt1
WHERE RNUM BETWEEN &page_size * (&page_no-1)+1 AND &page_size * (&page_no-1)+&page_size;
--WHERE RNUM BETWEEN 11 AND 20;