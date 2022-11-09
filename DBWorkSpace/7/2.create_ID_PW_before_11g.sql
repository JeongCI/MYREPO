-- 사용자 생성 (11g 이전 방법으로 계정 생성)
ALTER SESSION SET "_oracle_script"=true;

-- 계정명 pcwk / 비번 goodman
CREATE USER pcwk
IDENTIFIED BY goodman
DEFAULT TABLESPACE goodman
TEMPORARY TABLESPACE temp;