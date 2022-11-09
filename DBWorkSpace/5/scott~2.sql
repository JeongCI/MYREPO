SELECT h_year,
       MAX (DECODE(h_month,1,h_month)) "m01",
       MAX (DECODE(h_month,2,h_month)) "m02",
       MAX (DECODE(h_month,3,h_month)) "m03",
       MAX (DECODE(h_month,4,h_month)) "m04",
       MAX (DECODE(h_month,5,h_month)) "m05",
       MAX (DECODE(h_month,6,h_month)) "m06",
       MAX (DECODE(h_month,7,h_month)) "m07",
       MAX (DECODE(h_month,8,h_month)) "m08",
       MAX (DECODE(h_month,9,h_month)) "m09",
       MAX (DECODE(h_month,10,h_month)) "m10",
       MAX (DECODE(h_month,11,h_month)) "m11",
       MAX (DECODE(h_month,12,h_month)) "m12"
FROM tb_pivot
GROUP BY h_year
;