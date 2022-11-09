--SELECT명령에 표현식(값) 출력하기								
--	표현식이란 컬럼 이름 이외에 출력하기를 원하는 내용을 의미한다.							
--	Ex)							
--		SELECT ' ' (작은따옴표)로 묶어서 사용한다.						
SELECT ename,
       ' good morning~~!' "Good Morning"
FROM emp;

/*
작은 따옴표 출력 : 작은 따옴표 1개를 출력하기 위해 2개를 사용한다.
*/
SELECT dname, ', it''s deptno : ',
       deptno
FROM dept;

SELECT dname, q'[, it's deptno : ]',
       deptno
FROM dept;

--컬럼의 별칭
SELECT empno as "employee_number",
       ename "employee_name",
       sal employee_pay
FROM emp;
