SELECT MONTHS_BETWEEN('22/08/31','22/09/30') "Small", --���� ��¥�� �ڿ� ����ؾ� �Ѵ�
       MONTHS_BETWEEN('22/09/30','22/08/31') "Big",
       MONTHS_BETWEEN('22/09/13','22/09/13') "same_month01", 
       MONTHS_BETWEEN('22/09/12','22/09/30') "same_month02",
       MONTHS_BETWEEN('20/03/01','20/02/28') "same_month03", --������ �ν� ���Ѵ�.
       MONTHS_BETWEEN('22/03/01','22/02/28') "same_month04"  --������ �ν� ���Ѵ�.
FROM dual
;