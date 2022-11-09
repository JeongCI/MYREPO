--회원가입시 입력 글자수 확인
SELECT ename, LENGTH(ename)
FROm emp
WHERE LENGTH(ename) > LENGTH('&ename')
;