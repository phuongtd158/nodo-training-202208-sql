--1. Hiển thị toàn bộ tên nhân viên và tên phòng ban làm việc sắp xếp theo tên phòng ban
SELECT ENAME, DNAME
FROM EMP,
     DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
ORDER BY DNAME

--2. Hiển thị tên nhân viên, vị trí địa lý, tên phòng với điều kiện lương >1500.
SELECT ENAME, LOC, DNAME
FROM EMP,
     DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
  AND EMP.SAL > 1500

--3. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương.
SELECT E.ENAME, E.JOB, E.SAL, S.GRADE
FROM EMP E,
     SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL

--4. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương, với điều kiện mức lương=3
SELECT ENAME, JOB, SAL, GRADE
FROM EMP E,
     SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
  AND S.GRADE = 3;

--5. Hiển thị những nhân viên tại DALLAS
SELECT ENAME, LOC, SAL
FROM EMP E,
     DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND D.LOC = 'DALLAS'

--6. Hiển thị tên nhân viên , nghề nghiệp, lương, mức lương, tên phòng làm việc trừ nhân
--viên có nghề là cleck và sắp xếp theo chiều giảm
SELECT E.ENAME, E.JOB, E.SAL, S.GRADE, D.DNAME
FROM EMP E,
     DEPT D,
     SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
  AND E.DEPTNO = D.DEPTNO
  AND E.JOB != 'CLERK'
ORDER BY DNAME DESC

--7. Hiển thị chi tiết về những nhân viên kiếm được 36000 $ 1 năm hoặc nghề là cleck.
--(gồm các trường tên, nghề, thu nhập, mã phòng, tên phòng, mức lương)
SELECT E.ENAME, E.JOB, E.SAL, D.DEPTNO, D.DNAME, S.GRADE
FROM EMP E,
     DEPT D,
     SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL
  AND E.DEPTNO = D.DEPTNO
  AND (E.SAL * 12 >= 36000
    OR E.JOB = 'CLERK')

--8. Hiển thị những phòng không có nhân viên nào làm việc
SELECT *
FROM DEPT
WHERE DEPTNO NOT IN (
    SELECT DISTINCT EMP.DEPTNO
    FROM EMP
    WHERE EMP.DEPTNO IS NOT NULL
);

--9. Hiển thị mã nhân viên, tên nhân viên, mã người quản lý, tên người quản lý
SELECT E.EMPNO, E.ENAME, M.MGR M_NO, M.ENAME M_NAME
FROM EMP E,
     EMP M
WHERE E.EMPNO = M.MGR
  AND E.SAL < M.SAL
--Như câu 9 hiển thị thêm thông tin về ông KING.

--11. Hiển thị nghề nghiệp được tuyển dụng vào năm 1981 và không được tuyển dụng vào năm 1994.
SELECT DISTINCT JOB
FROM EMP
WHERE TO_CHAR(HIREDATE, 'yyyy') = 1981
  AND JOB NOT IN (
    SELECT DISTINCT JOB
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'yyyy') = 1994
)

--12. Tìm những nhân viên gia nhập công ty trước giám đốc của họ.
SELECT *
FROM EMP
WHERE JOB != 'MANAGER'
  AND HIREDATE < ALL (
    select HIREDATE
    from EMP
    where JOB = 'MANAGER'
);
--13. Tìm tất cả các nhân viên, ngày gia nhập công ty, tên nhân viên, tên người giám đốc và ngày gia nhập công ty của người giám đốc ấy
SELECT E.ENAME, E.HIREDATE, M.ENAME, M.HIREDATE
FROM EMP E,
     EMP M
WHERE E.EMPNO = M.MGR

--14. Tìm những nhân viên kiếm được lương cao nhất trong mỗi loại nghề nghiệp.
SELECT JOB, MAX(SAL)
FROM EMP
WHERE JOB IS NOT NULL
GROUP BY JOB

--15. Tìm mức lương cao nhất trong mỗi phòng ban, sắp xếp theo thứ tự phòng ban.
SELECT E.ENAME, E.JOB, E.DEPTNO, E.SAL
FROM EMP E
WHERE E.SAL = ANY (
    SELECT MAX(SAL)
    FROM EMP
    GROUP BY DEPTNO
)



