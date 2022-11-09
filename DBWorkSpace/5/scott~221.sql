SELECT *
FROM customer
;

SELECT *
FROM gift
;

SELECT t1.gname "cust_name",
       t1.point,
       t2.gname "gift_name"
FROM customer t1, gift t2
WHERE t1.point >= t2.g_start
AND t2.gname = 'Notebook'
;