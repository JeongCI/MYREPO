SELECT ename,LENGTH(ename) "LENGTH"
FROM emp
WHERE deptno = 20
;

SELECT LENGTH('�ѱ�') "LENGTH_KOR",
       LENGTHB('�ѱ�') "LENGTH_KOR_B"
FROM dual
;