SELECT COUNT(*) FROM board;

SELECT A.*, B.*
FROM (
    SELECT tt1.RNUM,											
           tt1.seq,											
           tt1.title,											
           tt1.mod_id,											
           DECODE(TO_CHAR(sysdate,'YYYYMMDD'), TO_CHAR(tt1.mod_dt,'YYYYMMDD')											
                                             , TO_CHAR(tt1.mod_dt,'HH24:MM')											
                                             , TO_CHAR(tt1.mod_dt,'YYYY.MM.DD')) motd_dt,											
           tt1.read_cnt											
    FROM(											
        SELECT rownum as Rnum,t1.*											
        FROM(											
            SELECT *											
            FROM board	
--            WHERE title LIKE '力格_10'||'%'
            ORDER BY mod_dt desc											
        )t1		
--        WHERE rownum <= &page_size * (&page_no-1)+&page_size
    )tt1											
--    WHERE rnum >= &page_size * (&page_no-1)+1
)A 
--NATURAL JOIN
--(SELECT COUNT(*)
--   FROM board
--   WHERE title LIKE '力格_10'||'%'
--   )B
   ;