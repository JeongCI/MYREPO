SELECT name,
       (SELECT t2.area -- �÷��� �ѹ��� 1���� ���
       FROM dept2 t2   -- �����Ͱ� 2row ��½� ����
       WHERE t1.deptno = t2.dcode) "dname"
FROM emp2 t1
;

SELECT name,
       t2.dname "dname"
FROM emp2 t1, dept2 t2
WHERE t1.deptno = t2.dcode
;