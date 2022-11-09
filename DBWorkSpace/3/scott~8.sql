SELECT SYSDATE,
       NEXT_DAY(SYSDATE, '월')
FROM dual
;

SELECT SYSDATE,
       LAST_DAY(SYSDATE),
       LAST_DAY('22/07/01')
FROM dual
;
--이번달 까지 할인 30% 적용한 가격으로 처리한다.