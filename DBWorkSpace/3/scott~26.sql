SELECT deptno,
       name,
       DECODE(deptno,101,'Computer Engineer','ETC') "DNAME"
FROM professor
;