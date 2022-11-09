SELECT name,
       pay,
       NVL(bonus,0) "BONUS",
       TO_CHAR((pay*12)+NVL(bonus,0),'9,999') "TOTAL_PAY"
FROM professor
WHERE deptno = 201
;