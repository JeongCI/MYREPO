SELECT 'A-B-C-D'
    ,INSTR('A-B-C-D','-',1) "INSTR"
    ,INSTR('A-B-C-D','-',1,3) "INSTR13"
    ,INSTR('A-B-C-D','-',3,1) "INSTR31"
    ,INSTR('A-B-C-D','-',-1,3) "INSTR-13" -- '-' ������ �����ʿ��� �������� ã�´�.
FROM dual
;