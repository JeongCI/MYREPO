SELECT studno
       ,name
FROM student t1
WHERE deptno1 = 101
UNION
SELECT profno
FROM professor
;
--ORA-01789: 질의 블록은 부정확한 수의 결과 열을 가지고 있습니다.