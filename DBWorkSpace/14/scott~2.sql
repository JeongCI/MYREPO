--���̺� ���� �� VIEW ����
CREATE TABLE o_table(
    A NUMBER,
    B NUMBER
);
CREATE OR REPLACE VIEW view01
AS (
SELECT A,B FROM o_table
);

--VIEW01 �� ������ �ֱ�
INSERT INTO VIEW01 VALUES (11,13);

--Ȯ��
SELECT A, B
FROM O_TABLE;