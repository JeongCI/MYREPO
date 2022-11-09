SELECT name,
       position,
       TO_CHAR(pay,'$999,999,999,999') "SALARY"
FROM emp2
WHERE pay > (SELECT MIN(pay)
             FROM emp2
             WHERE position = 'Section head')
ORDER BY pay DESC
;