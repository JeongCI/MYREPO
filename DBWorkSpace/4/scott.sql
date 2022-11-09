SELECT name,
       jumin,
       CASE WHEN substr(jumin,3,2) BETWEEN '01' AND '03' THEN '1/4'
            WHEN substr(jumin,3,2) BETWEEN '04' AND '06' THEN '2/4'
            WHEN substr(jumin,3,2) BETWEEN '07' AND '09' THEN '3/4'
            WHEN substr(jumin,3,2) BETWEEN '10' AND '12' THEN '4/4'
       END "Quarter"
FROM student
;