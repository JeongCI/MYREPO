SELECT SYSDATE,
       NEXT_DAY(SYSDATE, '��')
FROM dual
;

SELECT SYSDATE,
       LAST_DAY(SYSDATE),
       LAST_DAY('22/07/01')
FROM dual
;
--�̹��� ���� ���� 30% ������ �������� ó���Ѵ�.