--student���̺��� jumin��ȣ �÷��� ����Ͽ� 1������ 101���� �л�����
--�̸�, �������, �����Ϸ� �� ��¥�� ���
SELECT name
      ,jumin
      ,SUBSTR(jumin,3,4) "BIRTHDAY"
      ,SUBSTR(jumin,3,4)-1 "BIRTHDAY-1"
FROM student
WHERE deptno1 = 101
;