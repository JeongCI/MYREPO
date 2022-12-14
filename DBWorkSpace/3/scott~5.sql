SELECT SYSDATE
FROM dual
;

ALTER SESSION SET NLS_DATE_FORMAT = 'RRRR/MM/DD';

SELECT SYSDATE
FROM dual
;

SELECT SYSDATE + 1 "TOMORROW",
       SYSDATE     "TODAY",
       SYSDATE - 1 "YESTERDAY"
FROM dual
;