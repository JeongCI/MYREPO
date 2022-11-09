SELECT deptno,
       SUBSTR( --맨 앞의 , 제거
       XMLAGG(XMLELEMENT (goo,',',ename) ORDER BY ename) --xml은 <goo>...</goo> 태그를 생성
       .EXTRACT('//text()').getStringVal() --xml을 텍스트로 변경 xml태그 삭제
       ,2)
       "dept_ename_list"
FROM emp
GROUP BY deptno
;
--XMLELEMENT : xml tag 생성
--EXTRACT('//text()').getStringVal() : xml을 텍스트로 변경, xml태그 삭제