SELECT *
FROM student
;
SELECT *
FROM HAKJUM -- min ~ max
;
SELECT *
FROM SCORE -- studno
;

SELECT t1.name STU_NAME,
       t2.total TOTAL,
       t3.grade GRADE
FROM student t1, score t2, hakjum t3
WHERE t1.studno = t2.studno
AND t2.total BETWEEN t3.min_point AND t3.max_point
;

SELECT t1.name STU_NAME,
       t2.total TOTAL,
       t3.grade GRADE
FROM student t1 JOIN score t2
ON t1.studno = t2.studno
JOIN hakjum t3
ON t2.total BETWEEN t3.min_point AND t3.max_point
;