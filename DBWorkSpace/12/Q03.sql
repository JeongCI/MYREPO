SELECT A.*, B.*
FROM (
    SELECT tt1.RNUM,                                                                                    
           tt1.seq,                                                                                     
           tt1.title,                                                                                   
           tt1.mod_id,                                                                                  
           DECODE(TO_CHAR(sysdate,'YYYYMMDD'), TO_CHAR(tt1.mod_dt,'YYYYMMDD')                                                                                   
                                             , TO_CHAR(tt1.mod_dt,'HH24:MI')                                                                                    
                                             , TO_CHAR(tt1.mod_dt,'YYYY.MM.DD HH24:MI:SS')) motd_dt,                                                                                       
           tt1.read_cnt                                                                                 
    FROM(                                                                                       
        SELECT rownum as Rnum,t1.*                                                                                      
        FROM(                                                                                   
            SELECT *                                                                                    
            FROM PC_board  
            WHERE title LIKE '力格_'||'%'
            ORDER BY mod_dt desc                                                                                        
        )t1             
        WHERE rownum <= 20
    )tt1                                                                                        
    WHERE rnum >= 1
)A NATURAL JOIN
(SELECT COUNT(*)
   FROM PC_board
   WHERE title LIKE '力格_'||'%'
   )B;