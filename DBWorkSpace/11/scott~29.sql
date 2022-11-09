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
        SELECT * --�ζ��� ��� ����ؼ� �ؾ߸� ����
        FROM board
        --�˻�����
        --WHERE title LIKE '����_10'||'%'
        --WHERE contents LIKE '����_100'||'%'
        ORDER BY mod_dt DESC
    )t1
    WHERE ROWNUM <= 10
)tt1
WHERE RNUM >= 1;
