SELECT studno
      ,name
      ,deptno1
      ,1 "tab_div"
FROM student t1
WHERE deptno1 = 101
UNION
SELECT profno
      ,name
      ,deptno
      ,2
FROM professor
WHERE deptno = 101
;
