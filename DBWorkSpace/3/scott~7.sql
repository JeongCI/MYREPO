--ADD_MONTHS : �־��� ��¥�� ������ ����(�� �� ����)
SELECT SYSDATE,
       ADD_MONTHS(SYSDATE, 2) "SYSDATE+2",
       ADD_MONTHS(SYSDATE, -2) "SYSDATE-2"
FROM dual
;