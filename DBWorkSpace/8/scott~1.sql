SELECT t1.num_rows,
       t1.blocks
FROM user_tables t1
WHERE t1.table_name = 'ST_PCWK_TBL'
;
-- ST_PCWK_TBL ������� ����
ANALYZE TABLE ST_PCWK_TBL COMPUTE STATISTICS;