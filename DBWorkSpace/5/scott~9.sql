--CREATE TABLE unpivot
--as
--SELECT * FROM(SELECT deptno,job,empno FROM emp)
--PIVOT ( COUNT(empno) FOR job IN(
--                                'CLERK' "CLERK",
--                                'MANAGER' "MANAGER",
--                                'PRESIDENT' "PRESIDENT",
--                                'ANALYST' "ANALYST",
--                                'SALESMAN' "SALESMAN"
--                                )
--)
--ORDER BY deptno
--;
--
SELECT * FROM unpivot;
desc unpivot;