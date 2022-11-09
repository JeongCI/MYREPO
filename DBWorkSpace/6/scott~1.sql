SELECT t1.name,
       t1.weight
FROM student t1
WHERE t1.weight > (SELECT AVG(weight)
                     FROM student
                     WHERE deptno1 = '201' )
;