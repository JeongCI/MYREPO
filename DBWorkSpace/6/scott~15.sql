-- 물리적으로 asc정렬
CREATE INDEX idx_with_pay ON with_test1(pay asc);

With a AS (
-- step 2.1 인덱스 사용해서 조회
-- ORACLE HINT
-- 최대값
SELECT /*+ INDEX_desc (w idx_with_pay) */ pay
FROM with_test1 w
WHERE pay>0
AND ROWNUM = 1
),b AS (
-- 최소값
SELECT /*+ INDEX_asc (w idx_with_pay) */ pay
FROM with_test1 w
WHERE pay>0
AND ROWNUM = 1
)
SELECT a.pay - b.pay
FROM a,b
;