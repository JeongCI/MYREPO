SELECT studno
       ,name
FROM student t1
UNION
SELECT name
       ,profno
FROM professor
;
--ORA-01790: �����ϴ� �İ� ���� ������ �����̾�� �մϴ�