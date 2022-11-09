SELECT * FROM (SELECT h_year,h_month FROM tb_pivot)
PIVOT( MAX (h_month) FOR h_month IN (
                                      1 as M01
                                      ,2 as M02
                                      ,3 as M03
                                      ,4 as M04
                                      ,5 as M05
                                      ,6 as M06
                                      ,7 as M07
                                      ,8 as M08
                                      ,9 as M09
                                      ,10 as M10
                                      ,11 as M11
                                      ,12 as M12
                                     )
);
--PIVOT절 : 그룹 함수 적용된 컬럼 : MAX(month)
--FOR절 : 피봇에 기준이 되는 컬럼 : FOR month
--IN절 : PIVOT FOR에서 정의한 컬럼 필터링 : 1 "m01" / 2 "m02"