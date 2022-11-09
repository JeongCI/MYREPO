SELECT T1.TOTAL||'EA' as TOTAL
       ,T1.JAN||'EA' as JAN
       ,T1.FEB||'EA' as FEB
       ,T1.MAR||'EA' as MAR
       ,T1.APR||'EA' as APR
       ,T1.MAY||'EA' as MAY
       ,T1.JUN||'EA' as JUN
       ,T1.JUL||'EA' as JUL
       ,T1.AUG||'EA' as AUG
       ,T1.SEP||'EA' as SEP
       ,T1.OCT||'EA' as OCT
       ,T1.NOV||'EA' as NOV
       ,T1.DEC||'EA' as DEC
FROM (
SELECT * FROM (SELECT COUNT(*) OVER() TOTAL, TO_CHAR(birthday,'MM') BIRTH FROM student)
PIVOT (COUNT(BIRTH) FOR BIRTH IN (
                                    '01' "JAN",
                                    '02' "FEB",
                                    '03' "MAR",
                                    '04' "APR",
                                    '05' "MAY",
                                    '06' "JUN",
                                    '07' "JUL",
                                    '08' "AUG",
                                    '09' "SEP",
                                    '10' "OCT",
                                    '11' "NOV",
                                    '12' "DEC"
                                    )
    )
)
;
                                    