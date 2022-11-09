SELECT studno
      ,name
FROM student t1
WHERE deptno1 = 101
UNION
SELECT studno
      ,name
FROM student t1
WHERE deptno2 = 201
;