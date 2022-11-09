-- comm null�� ��� : �ش���� ����
-- comm 0�� ��� : ���� ����
-- comm > 0 ��� : ���� : ���
SELECT empno,
       ename,
       comm,
       CASE WHEN comm IS NULL THEN '�ش���� ����'
            WHEN comm = 0 THEN '���� ����'
            WHEN comm > 0 THEN '���� :' || comm
       END "COMM_TEXT"
FROM emp
;