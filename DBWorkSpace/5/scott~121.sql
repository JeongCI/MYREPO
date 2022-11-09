SELECT t1.gname,
       t1.point,
       t2.gname gift_name
FROM CUSTOMER t1, GIFT t2
WHERE t1.point BETWEEN g_start AND g_end
;