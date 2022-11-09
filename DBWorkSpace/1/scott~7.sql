SELECT studno
      ,name
FROM student t1
WHERE deptno1 = 101
UNION ALL
SELECT studno
      ,name
FROM student t1
WHERE deptno2 = 201
;