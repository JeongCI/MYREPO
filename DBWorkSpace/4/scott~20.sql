SELECT grade,deptno1,count(*)
FROM student
GROUP BY GROUPING SETS(grade,deptno1)
ORDER BY 1,2
;