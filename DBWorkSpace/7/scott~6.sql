--emp�� ctas�λ���(emp���̺��� �ٽý���ϴϱ� ���� ������ ���� ���̺���)
CREATE TABLE emp_alter
AS
SELECT *
FROM emp;
--���̺� Ȯ��
SELECT
    * FROM emp_alter;
--ADD ���̺� ���߰� = �÷��߰�(���߰�)
--HP  VARCHAR2(13 BYTE) �÷��߰�
ALTER TABLE emp_alter
ADD HP VARCHAR2 (13 BYTE);