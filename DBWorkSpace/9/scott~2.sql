INSERT INTO pc_unique (
    login_id,
    login_pwd,
    tel
) VALUES (
    'TEST_ID_01',
    '4321',
    '010-1234-5678'
);

INSERT INTO pc_unique (
    login_id,
    login_pwd,
    tel
) VALUES (
    'TEST_ID_01',
    '43219',
    '010-1234-5679'
);

--login_id °ª NULL ÀÔ·Â
INSERT INTO pc_unique (
    login_id,
    login_pwd,
    tel
) VALUES (
    NULL,
    '4321',
    '010-1234-5678'
);

INSERT INTO pc_unique (
    login_id,
    login_pwd,
    tel
) VALUES (
    NULL,
    '43217',
    '010-1234-5678'
);