-- ����
CREATE OR REPLACE FUNCTION func_aftertax 
(
    sal in number
)
RETURN NUMBER
IS
    TAX NUMBER := 0.05;
BEGIN
    RETURN ROUND(sal - (SAL * tax));

END;
/
--����
--SELECT func_aftertax(100) FROM DUAL;
SELECT ename, sal, func_aftertax(sal)
FROM emp;