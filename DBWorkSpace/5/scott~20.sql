SELECT * FROM(SELECT COUNT(*) OVER() "TOTAL",SUBSTR(tel,1,INSTR(tel,')')-1) FROM student)
PIVOT (COUNT(*) FOR tel IN (
                            '02' "SEOUL",
                            '031' "GYENGGI",
                            '051' "BUSAN",
                            '052' "UNSLA",
                            '053' "DAEGU",
                            '055' "GYEONGNAM"
                            )
)
;