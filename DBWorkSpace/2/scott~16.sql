SELECT ename,
       LTRIM(ename,'C') "LTRIM",
       LTRIM(' ' || ename) "LTRIM2" --���Ź��� �����ϸ� DEFAULT ' '
FROM emp
WHERE deptno = 10
;