-- ���ν��� ����
CREATE OR REPLACE PROCEDURE pro_param_in
(
    param01 IN NUMBER,
    param02 NUMBER,    --MODE �����ϸ� DEFAULT IN
    param03 NUMBER := 3,
    param04 IN NUMBER DEFAULT 4
)
IS

BEGIN
    DBMS_OUTPUT.PUT_LINE('param01: '||param01 );
    DBMS_OUTPUT.PUT_LINE('param02: '||param02 );
    DBMS_OUTPUT.PUT_LINE('param03: '||param03 );
    DBMS_OUTPUT.PUT_LINE('param04: '||param04 );
END;
/

-- �Ķ� ���� : 4 (���� �Ϸ�)
EXECUTE pro_param_in(1,2,8,9);
-- �Ķ� ���� : 2 (���� �Ϸ�)
EXECUTE pro_param_in(1,2);
-- �Ķ� ���� : 1 (���� �߻�)
EXECUTE pro_param_in(1);