CREATE OR REPLACE PACKAGE BODY PKG_EXAMPLE
IS
    body_no NUMBER := 10;
    
    FUNCTION func_aftertax(sal NUMBER) RETURN NUMBER
    IS
        tax number := 0.05;
    BEGIN
        return round(sal-(sal*tax));
    END func_aftertax;
    
    procedure Pro_emp(in_empno IN EMP.empno%type)
    IS 
        out_ename EMP.Ename%type;
        out_sal emp.sal%type;
    BEGIN
        SELECT ename, sal
        INTO out_ename, out_sal
        FROM emp
        WHERE empno = in_empno;
        
    DBMS_OUTPUT.PUT_LINE('ename: '||out_ename);
    DBMS_OUTPUT.PUT_LINE('sal: '||out_sal);
    
    END pro_emp;
    
    PROCEDURE pro_dept(in_deptno IN dept.deptno%TYPE)
    IS
        out_dname dept.dname%TYPE;
        out_loc dept.loc%type;
    BEGIN
        SELECT dname, loc
        INTO out_dname, out_loc
        FROM dept
        WHERE deptno = in_deptno;
        
        DBMS_OUTPUT.PUT_LINE('dname: '||out_dname);
        DBMS_OUTPUT.PUT_LINE('loc: '||out_loc);
    
    END pro_dept;

END PKG_EXAMPLE;
/