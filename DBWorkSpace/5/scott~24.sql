SELECT cat_a.no,
       cat_a.name,
       cat_b.name
FROM cat_a, cat_b
WHERE cat_a.no = cat_b.no
;
--테이블 이름 + 컬럼 이름
