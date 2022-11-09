SELECT ename,
       LTRIM(ename,'C') "LTRIM",
       LTRIM(' ' || ename) "LTRIM2" --제거문자 생략하면 DEFAULT ' '
FROM emp
WHERE deptno = 10
;