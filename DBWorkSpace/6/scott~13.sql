CREATE TABLE with_test1(
no NUMBER,
name VARCHAR2(10),
pay NUMBER(6)
)
TABLESPACE USERS;


BEGIN
    FOR i IN 1..5000000 LOOP
        INSERT INTO with_test1 VALUES (i,
                                       DBMS_RANDOM.STRING('A',5), --��ҹ��� ���� ���� ������ 5�ڸ� ���� �߻�
                                       DBMS_RANDOM.value(6,999999) --���� 6 �ڸ� ���� �߻�
                                       );
    END LOOP;
    commit; -- Ȯ��
END;
/

--SQL Developer������ ��ü ��ȸ�ص� 50�Ǿ� ��µ�
--��ũ���� ������ �� �� 50�� �� �߰� ���
--java�� �ְ� sql�� ���� ��Ű�� 500�� ���� ��ȸ �Ϸ� �� �� ���� ������ ����
SELECT COUNT(*)
FROM with_test1;