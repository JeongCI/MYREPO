SELECT t1.name stud_name, t2.name prof_name
FROM student t1 FULL OVER JOIN professor t2
ON t1.profno = t2.profno
;