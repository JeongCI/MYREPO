SELECT deptno,
       name,
       DECODE(deptno,101,'Computer Engineer') "DNAME"
FROM professor
;