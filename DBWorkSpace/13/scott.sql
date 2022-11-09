-- 패키지 생성
CREATE OR REPLACE PACKAGE PKG_EXAMPLE
IS
	spec_no NUMBER := 10;
    
    FUNCTION func_aftertax(sal NUMBER) RETURN NUMBER;
    
    PROCEDURE pro_emp(in_empno IN emp.empno%type);
    
    PROCEDURE pro_dept(in_deptno IN dept.deptno%TYPE);
	
END PKG_EXAMPLE;
/