--STUDENT���̺��� 1������ 201�� �л��� �̸�, ��ȭ��ȣ, ������ȣ�� ���
--�� ������ȣ�� ���ڸ� ���;� ��.
SELECT name,
       TEL,
       INSTR(tel,')') "instr",
       SUBSTR(tel,1,INSTR(tel,')')-1) "AREA"
FROM student
WHERE deptno1 = 201
;