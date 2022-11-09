--STUDENT테이블에서 1전공이 201번인 학과 학생들의 ID를 총 10자리 출력 빈자리는 '*'
SELECT name,
       id,
       LPAD(ID,10,'*') "LPAD"
FROM student
WHERE deptno1 = 201
;