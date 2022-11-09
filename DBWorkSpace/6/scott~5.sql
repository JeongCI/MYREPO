SELECT name,
       grade,
       weight
FROM student
WHERE weight <ALL(SELECT MIN(weight)
                  FROM student
                  WHERE grade = '2')
ORDER BY 3 DESC
;