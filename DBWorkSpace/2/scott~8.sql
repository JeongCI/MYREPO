--ȸ�����Խ� �Է� ���ڼ� Ȯ��
SELECT ename, LENGTH(ename)
FROm emp
WHERE LENGTH(ename) > LENGTH('&ename')
;