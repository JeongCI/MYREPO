--emp2 ���̺��� ��ȸ�ؼ� ������ �� �ڽ��� ������ ��� ������ ���ų� 
--���� �޴� ������� �̸�, ����, ���翬�� ���
SELECT t1.name,
       t1.position,
       t1.pay
FROM emp2 t1
WHERE t1.pay >= (SELECT AVG(t2.pay)
                FROM emp2 t2
                WHERE t2.position = t1.position)
;