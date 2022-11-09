SELECT t1.no,
       t1.name,
       t2.name
FROM cat_a t1, cat_b t2
--WHERE cat_a.no = cat_b.no
;
--카테시언 프로덕트 : cat_a테이블의 데이터 건수 * cat_B테이블의 데이터 건수 = 3.2