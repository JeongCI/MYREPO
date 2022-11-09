SELECT a.name PROF_NAME,
       TO_CHAR(a.hiredate,'YYYY-MM-DD') HIREDATE,
       b.dname
FROM professor a, department b
WHERE a.deptno = b.deptno
AND a.hiredate > (SELECT hiredate
                   FROM professor
                   WHERE name = 'Meg Ryan')
ORDER BY hiredate
;