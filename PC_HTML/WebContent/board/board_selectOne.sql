SELECT T1.*
FROM(
    SELECT seq,
           LAG(seq, 1, 0)OVER (ORDER BY mod_dt DESC) pre_seq,
           LAG(title, 1, '이전글 없음')OVER (ORDER BY mod_dt DESC) pre_title,
           LEAD(seq, 1, 0)OVER (ORDER BY mod_dt DESC) next_seq,
           LEAD(title, 1, '다음글 없음')OVER (ORDER BY mod_dt DESC) next_title
    FROM board
    --조회조건
)T1
WHERE seq = 278
;