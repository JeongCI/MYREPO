SELECt name,
           (SELECT t2.dname, t2.area
            FROM dept2 t2
            WHERE t1.deptno = t2.dcode
            )"