SELECT trunc(987.654,2) "TRUNC1",
       trunc(987.659,0) "TRUNC2", --�Ҽ��� ù°�ڸ� ����
       trunc(987.654,-1) "TRUNC3" --�ڿ��� ù°�ڸ� ����
FROM dual
;