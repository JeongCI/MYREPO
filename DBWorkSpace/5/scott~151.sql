--SELECT name, profno
--FROM STUDENT 
--;


SELECT t1.name stud_name, t2.name prof_name
FROM student t1, professor t2
WHERE t1.profno = t2.profno
;
--inner joint �� 15�� : 5���� ������ ����

SELECT t1.name stud_name, t2.name prof_name
FROM student t1, professor t2
WHERE t1.profno = t2.profno(+)
;
--�����Ͱ� ���� �ʿ� (+)

SELECT t1.name stud_name, t2.name prof_name
FROM student t1 LEFT OUTER JOIN professor t2
ON t1.profno = t2.profno
;