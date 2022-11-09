--student테이블에서 jumin번호 컬럼을 사용하여 1전공이 101번인 학생들의
--이름, 출생월일, 생일하루 전 날짜를 출력
SELECT name
      ,jumin
      ,SUBSTR(jumin,3,4) "BIRTHDAY"
      ,SUBSTR(jumin,3,4)-1 "BIRTHDAY-1"
FROM student
WHERE deptno1 = 101
;