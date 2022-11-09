-- UNIQUE �ε��� ����
CREATE UNIQUE INDEX IDX_DEPT2_DNAME
ON DEPT2(DNAME ASC);

-- 1�� ������
INSERT INTO dept2 (
    dcode,
    dname,
    pdept,
    area
) VALUES (
    9101,
    'TEMP01',
    1006,
    'SEOUL BRANCH'
);
-- 2�� ������ (DNAME�� �Ȱ���)
INSERT INTO dept2 (
    dcode,
    dname,
    pdept,
    area
) VALUES (
    9201,
    'TEMP01',
    1006,
    'SEOUL BRANCH02'
);
--���� ���� -
--ORA-00001: ���Ἲ ���� ����(SCOTT.IDX_DEPT2_DNAME)�� ����˴ϴ�
--����, �̷��� �ߺ��� ���� �Էµ� ���ɼ��� ���� �÷��� ����ؾ� �Ѵ�.