SELECT name,
       (SELECT t2.area -- 컬럼이 한번에 1개만 출력
       FROM dept2 t2   -- 데이터가 2row 출력시 오류
       WHERE t1.deptno = t2.dcode) "dname"
FROM emp2 t1
;

SELECT name,
       t2.dname "dname"
FROM emp2 t1, dept2 t2
WHERE t1.deptno = t2.dcode
;