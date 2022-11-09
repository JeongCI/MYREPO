SELECT trunc(987.654,2) "TRUNC1",
       trunc(987.659,0) "TRUNC2", --소숫점 첫째자리 버림
       trunc(987.654,-1) "TRUNC3" --자연수 첫째자리 버림
FROM dual
;