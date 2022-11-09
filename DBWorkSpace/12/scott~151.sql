--생성
CREATE OR REPLACE PROCEDURE pro_err

IS
    error_no NUMBER;
BEGIN
    errno_no = 100; 
    DBMS_OUTPUT.PUT_LINE('error_no : '||error_no);
END;
/
LINE/COL  ERROR
--------- -------------------------------------------------------------
6/14      PLS-00103: 심볼 "="를 만났습니다 다음 중 하나가 기대될 때:    := . ( @ % ; 심볼이 ":= 계속하기 위해 "=" 전에 삽입되었음
오류: 컴파일러 로그를 확인하십시오.

--SHOW ERRORS로 오류 확인
SHOW ERRORS;
LINE/COL ERROR
-------- ------------------------------------------------------
6/14     PLS-00103: 심볼 "="를 만났습니다 다음 중 하나가 기대될 때:
         := . ( @ % ;
         심볼이 ":= 계속하기 위해 "=" 전에 삽입되었음