SET SERVEROUTPUT ON;
DECLARE
    no_empid exception;
BEGIN
  --  DBMS_OUTPUT.PUT_LINE('')
  delete from emp
  where empno = 88888;
  
  if sql%notfound then
    raise no_empid;
  end if;
    
  exception
    when no_empid then
        DBMS_OUTPUT.PUT_LINE('�Է��Ͻ� ��ȣ�� ���� �����ȣ �Դϴ�.');
END;
/