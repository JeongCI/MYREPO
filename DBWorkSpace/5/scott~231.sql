SELECT t1.profno,
       t1.name,
       TO_CHAR(t1.hiredate,'YYYY/MM/DD'),
       COUNT(t2.hiredate) "CNT"
FROM professor t1, professor t2
WHERE t1.hiredate > t2.hiredate(+)
GROUP BY t1.profno,t1.name,t1.hiredate
ORDER BY 3
;

SELECT t1.profno,
       t1.name,
       TO_CHAR(t1.hiredate,'YYYY/MM/DD'),
       COUNT(t2.hiredate) "CNT"
FROM professor t1 LEFT OUTER JOIN professor t2
ON t1.hiredate > t2.hiredate(+)
GROUP BY t1.profno,t1.name,t1.hiredate
ORDER BY 3
;
