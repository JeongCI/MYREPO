SELECT sal,
       TO_CHAR(sal,'$999,999') "sal_$",
       TO_CHAR(sal,'L999,999') "sal_L",
       TO_CHAR(sal,'00999,999') "sal_0",
       TO_CHAR(sal,'00999,999.00') "sal_00"
FROM emp
;