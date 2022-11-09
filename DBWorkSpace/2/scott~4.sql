--UPPER: 소문자를 대문자로
--LOWER: 대문자를 소문자로
--INITCAP: 첫 글자 대문자로

SELECT ename,
       LOWER(ename) "lower_name",
       INITCAP(ename) "initcap_name"
       UPPER(ename) "upper_name"
FROM emp
;