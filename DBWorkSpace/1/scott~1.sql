--SELECT��ɿ� ǥ����(��) ����ϱ�								
--	ǥ�����̶� �÷� �̸� �̿ܿ� ����ϱ⸦ ���ϴ� ������ �ǹ��Ѵ�.							
--	Ex)							
--		SELECT ' ' (��������ǥ)�� ��� ����Ѵ�.						
SELECT ename,
       ' good morning~~!' "Good Morning"
FROM emp;

/*
���� ����ǥ ��� : ���� ����ǥ 1���� ����ϱ� ���� 2���� ����Ѵ�.
*/
SELECT dname, ', it''s deptno : ',
       deptno
FROM dept;

SELECT dname, q'[, it's deptno : ]',
       deptno
FROM dept;

--�÷��� ��Ī
SELECT empno as "employee_number",
       ename "employee_name",
       sal employee_pay
FROM emp;
