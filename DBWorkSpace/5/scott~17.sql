SELECT CASE WHEN SUBSTR(birthday,4,2) = '01' THEN 'Jan'
            WHEN SUBSTR(birthday,4,2) = '02' THEN 'Feb'
            WHEN SUBSTR(birthday,4,2) = '03' THEN 'Mar'
            WHEN SUBSTR(birthday,4,2) = '04' THEN 'Apr'
            WHEN SUBSTR(birthday,4,2) = '05' THEN 'May'
            WHEN SUBSTR(birthday,4,2) = '06' THEN 'Jun'
            WHEN SUBSTR(birthday,4,2) = '07' THEN 'Jul'
            WHEN SUBSTR(birthday,4,2) = '08' THEN 'Aug'
            WHEN SUBSTR(birthday,4,2) = '09' THEN 'Sep'
            WHEN SUBSTR(birthday,4,2) = '10' THEN 'Oct'
            WHEN SUBSTR(birthday,4,2) = '11' THEN 'Nov'
            WHEN SUBSTR(birthday,4,2) = '12' THEN 'Dec'
            END "abc",
       RPAD(COUNT(SUBSTR(birthday,4,2)),3,'EA') "CNT"
FROM student
GROUP BY SUBSTR(birthday,4,2)
ORDER BY SUBSTR(birthday,4,2)
;