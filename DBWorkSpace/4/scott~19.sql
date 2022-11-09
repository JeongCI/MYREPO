SELECT grade,count(*)
FROM student
GROUP BY grade
UNION
SELECT deptno1,COUNT(*)
FROM student
GROUP BY deptno1
;