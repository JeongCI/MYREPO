SELECT deptno,
       SUBSTR( --�� ���� , ����
       XMLAGG(XMLELEMENT (goo,',',ename) ORDER BY ename) --xml�� <goo>...</goo> �±׸� ����
       .EXTRACT('//text()').getStringVal() --xml�� �ؽ�Ʈ�� ���� xml�±� ����
       ,2)
       "dept_ename_list"
FROM emp
GROUP BY deptno
;
--XMLELEMENT : xml tag ����
--EXTRACT('//text()').getStringVal() : xml�� �ؽ�Ʈ�� ����, xml�±� ����