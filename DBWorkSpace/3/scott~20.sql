--TO_DATE('����')
--TO_DATE('����','��¥����')
SELECT SYSDATE,
       TO_DATE('2022/09/13') "YYYY/MM/DD" ,
       TO_DATE('2022/09/13', 'YYYY-MM-DD') "YYYY-MM-DD",
       TO_DATE('20220913', 'YYYYMMDD')+1 "YYYYMMDD"
FROM dual
;