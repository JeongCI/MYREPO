SELECT ename,
       REPLACE(ename,SUBSTR(ename,1,2),'**') "REPLACE"
FROM emp
WHERE deptno = 10
;

SELECT name,
       REPLACE(jumin,SUBSTR(jumin,7,7),'-/-/-/-') "JUMIN"
FROM student
WHERE deptno1 = 101
;

SELECT name,
       REPLACE(tel,SUBSTR(tel,INSTR(tel,'-')+1,4),'****') "REPLACE"
FROM student
WHERE deptno1 = 101
;