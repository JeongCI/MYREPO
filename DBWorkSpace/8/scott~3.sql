SELECT name,
       position,
       pay
FROM professor_up
WHERE position IN(SELECT position
                  FROM professor_up
                  WHERE name = 'Sharon Stone')
AND pay < 250
;

UPDATE professor_up
set pay = pay*1.15
WHERE position IN(SELECT position
                  FROM professor_up
                  WHERE name = 'Sharon Stone')
AND pay < 250
;

SELECT name,
       position,
       pay
FROM professor_up
WHERE position IN(SELECT position
                  FROM professor_up
                  WHERE name = 'Sharon Stone')
;
COMMIT;

ROLLBACK;
