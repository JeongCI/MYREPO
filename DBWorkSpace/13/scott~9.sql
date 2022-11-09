-- UNIQUE 인덱스 생성
CREATE UNIQUE INDEX IDX_DEPT2_DNAME
ON DEPT2(DNAME ASC);

-- 1차 데이터
INSERT INTO dept2 (
    dcode,
    dname,
    pdept,
    area
) VALUES (
    9101,
    'TEMP01',
    1006,
    'SEOUL BRANCH'
);
-- 2차 데이터 (DNAME만 똑같이)
INSERT INTO dept2 (
    dcode,
    dname,
    pdept,
    area
) VALUES (
    9201,
    'TEMP01',
    1006,
    'SEOUL BRANCH02'
);
--오류 보고 -
--ORA-00001: 무결성 제약 조건(SCOTT.IDX_DEPT2_DNAME)에 위배됩니다
--현재, 미래에 중복된 값이 입력될 가능성이 없는 컬럼에 사용해야 한다.