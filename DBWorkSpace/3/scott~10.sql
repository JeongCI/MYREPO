--명시적 형변환: 숫자형 문자가 숫자로 형변환
SELECT 2+ TO_NUMBER ('3')
FROM dual
;
--묵시적 형변환
SELECT 2 + '3'
FROM dual
;