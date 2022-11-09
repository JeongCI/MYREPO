SELECT A.*, b.*
FROM(
    SELECT tt1.rnum no, --Ãâ·Â foramt 
           tt1.empno,
           tt1.job,
           tt1.mgr,
           TO_CHAR(tt1.hiredate,'YYYY.MM.DD') hiredate,
           tt1.sal,
           tt1.comm,
           tt1.deptno,
           tt1.dname,
           tt1.loc
    FROM(
        SELECT rownum as rnum, t1.*
        FROM (
            SELECT T1.*, T2.dname,t2.loc
            FROM EMP T1, DEPT T2
            WHERE T1.DEPTNO = T2.DEPTNO
            --ORDER BY Àý
        )t1
        WHERE rownum <= 20
    )tt1
    WHERE rnum >= 1
)A NATURAL JOIN
(SELECT COUNT(*) total_cnt
FROM EMP T1, DEPT T2
WHERE T1.DEPTNO = T2.DEPTNO)B;