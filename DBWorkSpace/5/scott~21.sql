SELECT MAX(TOTAL) TOTAL
       ,COUNT(DECODE(area,'02','0')) as SEOUL
       ,COUNT(DECODE(area,'031','0')) as GYEONGGI
       ,COUNT(DECODE(area,'051','0')) as BUSAN
       ,COUNT(DECODE(area,'052','0')) as ULSAN
       ,COUNT(DECODE(area,'053','0')) as DAEGU
       ,COUNT(DECODE(area,'055','0')) as GYEONGNAM
FROM (
      SELECT SUBSTR(tel,1,INSTR(tel,')')-1) area,
             tel,
             COUNT(*)OVER() TOTAL
        FROM student
        )
;