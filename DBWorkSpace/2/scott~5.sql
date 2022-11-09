--WHERE절의 왼쪽은 데이터량이 많은 경우 가공하면 않된다.
SELECT *
FROM emp
WHERE UPPER(ename) = UPPER('scott')
;