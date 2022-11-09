SELECT t1.no,
       t1.name,
       t2.name,
       t3.name
FROM cat_a t1, cat_b t2, cat_c t3
WHERE t1.no = t2.no
;
--AND t1.no = t3.no -- join 조건 누락