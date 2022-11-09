SELECT *
FROM professor
;
SELECT *
FROM department
;

SELECT t1.profno,
       t1.name "PROF_NAME",
       TO_CHAR(t1.hiredate,'YYYY-MM-DD') "HIREDATE",
       t2.dname "DEPT_NAME"
FROM professor t1, department t2
WHERE t1.deptno = t2.deptno
AND (t1.deptno,t1.hiredate) IN(SELECT deptno,
                                      MIN(hiredate)
                               FROM professor
                               GROUP BY deptno)
ORDER BY hiredate
;