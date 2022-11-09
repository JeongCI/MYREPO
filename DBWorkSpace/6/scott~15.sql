-- ���������� asc����
CREATE INDEX idx_with_pay ON with_test1(pay asc);

With a AS (
-- step 2.1 �ε��� ����ؼ� ��ȸ
-- ORACLE HINT
-- �ִ밪
SELECT /*+ INDEX_desc (w idx_with_pay) */ pay
FROM with_test1 w
WHERE pay>0
AND ROWNUM = 1
),b AS (
-- �ּҰ�
SELECT /*+ INDEX_asc (w idx_with_pay) */ pay
FROM with_test1 w
WHERE pay>0
AND ROWNUM = 1
)
SELECT a.pay - b.pay
FROM a,b
;