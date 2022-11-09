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
--PIVOT�� : �׷� �Լ� ����� �÷� : MAX(month)
--FOR�� : �Ǻ��� ������ �Ǵ� �÷� : FOR month
--IN�� : PIVOT FOR���� ������ �÷� ���͸� : 1 "m01" / 2 "m02"