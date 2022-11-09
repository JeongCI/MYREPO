SELECT studno
       ,name
FROM student t1
UNION
SELECT name
       ,profno
FROM professor
;
--ORA-01790: 대응하는 식과 같은 데이터 유형이어야 합니다