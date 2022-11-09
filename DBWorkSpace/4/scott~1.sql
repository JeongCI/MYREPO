-- comm null인 경우 : 해당사항 없음
-- comm 0인 경우 : 수당 없음
-- comm > 0 경우 : 수당 : 결과
SELECT empno,
       ename,
       comm,
       CASE WHEN comm IS NULL THEN '해당사항 없음'
            WHEN comm = 0 THEN '수당 없음'
            WHEN comm > 0 THEN '수당 :' || comm
       END "COMM_TEXT"
FROM emp
;