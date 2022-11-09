SELECT deptno,
       name,
       DECODE(deptno,101,'Computer Engineering'
                    ,102,'Mutimedia Engineering'
                    ,103,'Software Engineering'
                    ,'ETC') "DNAME"
FROM professor
;