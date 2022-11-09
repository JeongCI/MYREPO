-- 사용자 정보 보기
SELECT t1.username,
       t1.user_id,
       t1.account_status,
       t1.expiry_date,
       t1.default_tablespace
FROM dba_users t1
WHERE t1.username = 'SCOTT'
;