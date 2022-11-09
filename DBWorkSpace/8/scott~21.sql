CREATE TABLE professor_up
AS
SELECT *
FROM professor
;

SELECT * FROM professor_up;

SELECT position,
       bonus,
       name
FROM professor_up
WHERE position = 'assistant professor'
;

UPDATE professor_up
SET bonus = 200
WHERE position = 'assistant professor'
;
COMMIT;