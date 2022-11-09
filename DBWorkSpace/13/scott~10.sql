--DEPT2 AREA �� NON-UNIQUE INDEX����
CREATE INDEX IDX_DEPT2_AREA
ON DEPT2 (AREA ASC);

SELECT /*+INDEX_ASC(T1 IDX_DEPT_AREA)*/ *
FROM DEPT2 T1
WHERE AREA > '0';
-- �ε��� ����
explain plan for
SELECT /*+ INDEX_ASC(t1 IDX_DEPT2_AREA) */  *
FROM dept2 t1
WHERE area > '0'
;
-- Ȯ��
col plan_table_output format a120;
select * from table(dbms_xplan.display);