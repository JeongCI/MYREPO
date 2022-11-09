SELECT name,
       jumin,
       DECODE(substr(jumin,7,1),1,'MAN'
                               ,2,'WOMAN'
                               ,3,'MAN'
                               ,4,'Woman') "Gender"
FROM student
WHERE deptno1 = 101
;