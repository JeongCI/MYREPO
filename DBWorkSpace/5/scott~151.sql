--SELECT name, profno
--FROM STUDENT 
--;


SELECT t1.name stud_name, t2.name prof_name
FROM student t1, professor t2
WHERE t1.profno = t2.profno
;
--inner joint 은 15건 : 5건이 보이지 않음

SELECT t1.name stud_name, t2.name prof_name
FROM student t1, professor t2
WHERE t1.profno = t2.profno(+)
;
--데이터가 없는 쪽에 (+)

SELECT t1.name stud_name, t2.name prof_name
FROM student t1 LEFT OUTER JOIN professor t2
ON t1.profno = t2.profno
;