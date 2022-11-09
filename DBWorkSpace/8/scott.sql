CREATE TABLE st_pcwk_tbl(
no NUMBER);

BEGIN 
    for i IN 1..100 LOOP
        INSERT INTO st_pcwk_tbl VALUES(i);    
    END LOOP;
    
    COMMIT;
END;
/

SELECT COUNT(*)
FROM st_pcwk_tbl
;