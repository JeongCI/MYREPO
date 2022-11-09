SELECT COUNT(*)||'EA' TOTAL
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'01',0))||'EA' as JAN
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'02',0))||'EA' as FEB
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'03',0))||'EA' as MAR
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'04',0))||'EA' as APR
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'05',0))||'EA' as MAY
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'06',0))||'EA' as JUN
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'07',0))||'EA' as NUL
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'08',0))||'EA' as AUG
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'09',0))||'EA' as SEP
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'10',0))||'EA' as OCT
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'11',0))||'EA' as NOV
       ,COUNT(DECODE(TO_CHAR(birthday,'MM'),'12',0))||'EA' as DEC
FROM student
;