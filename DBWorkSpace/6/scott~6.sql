SELECT *
FROM emp2
;

SELECT *
FROM dept2
;

SELECT t2.dname,
       t1.name,
       TO_CHAR(t1.pay,'$999,999,999') "SALARY"
FROM emp2 t1, dept2 t2
WHERE t1.deptno = t2.dcode
AND t1.pay <all(SELECT AVG(pay)
                  FROM emp2
                  GROUP BY deptno)
ORDER BY 3
;