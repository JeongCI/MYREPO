SELECT ename,LENGTH(ename) "LENGTH"
FROM emp
WHERE deptno = 20
;

SELECT LENGTH('한글') "LENGTH_KOR",
       LENGTHB('한글') "LENGTH_KOR_B"
FROM dual
;