SELECT h_year,
       DECODE(h_month,1,h_month) "m01",
       DECODE(h_month,2,h_month) "m02",
       DECODE(h_month,3,h_month) "m03",
       DECODE(h_month,4,h_month) "m04",
       DECODE(h_month,5,h_month) "m05",
       DECODE(h_month,6,h_month) "m06",
       DECODE(h_month,7,h_month) "m07",
       DECODE(h_month,8,h_month) "m08",
       DECODE(h_month,9,h_month) "m09",
       DECODE(h_month,10,h_month) "m10",
       DECODE(h_month,11,h_month) "m11",
       DECODE(h_month,12,h_month) "m12"
FROM tb_pivot
;
--CREATE TABLE TB_PIVOT
--(
--    h_year  VARCHAR2(4)
--   ,h_month NUMBER(2)
--);
--
--INSERT INTO TB_PIVOT VALUES('2022',1);
--INSERT INTO TB_PIVOT VALUES('2022',2);
--INSERT INTO TB_PIVOT VALUES('2022',3);
--INSERT INTO TB_PIVOT VALUES('2022',4);
--INSERT INTO TB_PIVOT VALUES('2022',5);
--INSERT INTO TB_PIVOT VALUES('2022',6);
--INSERT INTO TB_PIVOT VALUES('2022',7);
--INSERT INTO TB_PIVOT VALUES('2022',8);
--INSERT INTO TB_PIVOT VALUES('2022',9);
--INSERT INTO TB_PIVOT VALUES('2022',10);
--INSERT INTO TB_PIVOT VALUES('2022',11);
--INSERT INTO TB_PIVOT VALUES('2022',12);
--COMMIT;
--
--SELECT *
--FROM TB_PIVOT
--;