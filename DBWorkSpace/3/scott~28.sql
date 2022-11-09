SELECT deptno,
       name,
       DECODE(deptno,101,DECODE(name,'Audie Murphy','BEST!',NULL)) "DNAME"
FROM professor
;