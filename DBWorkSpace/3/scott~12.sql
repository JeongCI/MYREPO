--�ð�
SELECT SYSDATE,
       TO_CHAR(SYSDATE, 'HH24') "HH24",
       TO_CHAR(SYSDATE, 'HH') "HH",
       TO_CHAR(SYSDATE, 'MI') "MI",
       TO_CHAR(SYSDATE, 'SS') "SS",
       TO_CHAR(SYSDATE, 'HH24:MI:SS') "HH24:MI:SS"
FROM dual
;