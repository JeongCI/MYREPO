SELECT SUBSTR('abcde',3,2) "3,2"
       ,SUBSTR('abcde',-3,2) "-3,2"
       ,SUBSTR('abcde',-3,4) "-3,4"
FROM dual
;