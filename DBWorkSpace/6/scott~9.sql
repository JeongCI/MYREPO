--emp2 테이블으 조회해서 직원들 중 자신의 직급의 평균 연봉과 같거나 
--많이 받는 사람들의 이름, 직급, 현재연봉 출력
SELECT t1.name,
       t1.position,
       t1.pay
FROM emp2 t1
WHERE t1.pay >= (SELECT AVG(t2.pay)
                FROM emp2 t2
                WHERE t2.position = t1.position)
;