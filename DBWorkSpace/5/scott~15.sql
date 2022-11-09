SELECT CASE WHEN comm IS NULL THEN 'X'
            WHEN comm IS NOT NULL THEN 'O'
            END "EXIST_COMM",
       COUNT(*)
FROM emp
GROUP BY comm
;