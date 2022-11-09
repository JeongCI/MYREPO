--STUDENT테이블에서 1전공이 201인 학생의 이름, 전화번호, 지역번호를 출력
--단 지역번호는 숫자만 나와야 함.
SELECT name,
       TEL,
       INSTR(tel,')') "instr",
       SUBSTR(tel,1,INSTR(tel,')')-1) "AREA"
FROM student
WHERE deptno1 = 201
;