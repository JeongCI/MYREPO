--UPPER: �ҹ��ڸ� �빮�ڷ�
--LOWER: �빮�ڸ� �ҹ��ڷ�
--INITCAP: ù ���� �빮�ڷ�

SELECT ename,
       LOWER(ename) "lower_name",
       INITCAP(ename) "initcap_name"
       UPPER(ename) "upper_name"
FROM emp
;