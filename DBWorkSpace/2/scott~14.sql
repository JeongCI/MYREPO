--STUDENT���̺��� 1������ 201���� �а� �л����� ID�� �� 10�ڸ� ��� ���ڸ��� '*'
SELECT name,
       id,
       LPAD(ID,10,'*') "LPAD"
FROM student
WHERE deptno1 = 201
;