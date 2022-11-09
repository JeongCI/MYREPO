--CREATE TABLE t_pragma
--(
--    no NUMBER PRIMARY KEY,
--    name VARCHAR2(20)
--);
--
--INSERT INTO t_pragma VALUES (1,'AAA');
--
--INSERT INTO t_pragma VALUES (1,'BBB');

SET SERVEROUTPUT ON;							
DECLARE							
	NEW_MSG EXCEPTION;						
	PRAGMA EXCEPTION_INIT(NEW_MSG,-1);
							
BEGIN							
	INSERT INTO t_pragma VALUES (1,'CCC');						
							
	EXCEPTION						
		WHEN NEW_MSG THEN					
			DBMS_OUTPUT.PUT_LINE('PK가 존재 합니다.');
							
END;							
/							
