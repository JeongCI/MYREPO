SELECT studno
       ,name
FROM student t1
WHERE deptno1 = 101
UNION
SELECT profno
FROM professor
;
--ORA-01789: ���� ����� ����Ȯ�� ���� ��� ���� ������ �ֽ��ϴ�.