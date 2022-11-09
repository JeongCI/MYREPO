SELECT p_date,
       p_code,
       p_qty,
       p_total,
       SUM(p_total)OVER(PARTITION BY p_code ORDER BY p_total) "TOTAL",
       p_store
FROM panmae
WHERE p_store = 1000
;