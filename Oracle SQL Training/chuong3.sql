--1: Chọn nhân viên trong bảng EMP có mức lương từ 1000 đến 2000 (chọn các trường ENAME, DEPTNO, SAL)
SELECT ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL BETWEEN 1000 AND 2000

--2: Hiển thị mã phòng ban, tên phòng ban, sắp xếp theo thứ tự tên phòng ban.
SELECT DEPTNO, DNAME
FROM DEPT
ORDER BY DNAME

--3: Hiển thị danh sách những nhân viên làm tại phòng 10 và 20 theo thứ tự A,B,C
SELECT *
FROM EMP
WHERE DEPTNO = 10
   OR DEPTNO = 20

--4: Hiển thị tên và nghề nghiệp những nhân viên làm nghề thư ký (cleck) tại phòng 20.
SELECT ENAME, JOB
FROM EMP
WHERE JOB = 'CLERK'
  AND DEPTNO = 20

--5: Hiển thị tất cả những nhân viên mà tên có các ký tự TH và LL.
SELECT ENAME
FROM EMP
WHERE ENAME LIKE '%TH%'
   OR ENAME LIKE '%LL%'

--6: Hiển thị tên nhân viên, nghề nghiệp, lương của những nhân viên có giám đốc quản lý.
SELECT DISTINCT ENAME, JOB, SAL
FROM EMP
WHERE JOB NOT LIKE 'PRESIDENT'

--7: Hiển thị tên nhân viên, mã phòng ban, ngày gia nhập công ty sao cho gia nhập công ty trong năm 1983
SELECT ENAME, DEPTNO, HIREDATE
FROM EMP
WHERE TO_CHAR(HIREDATE, 'yyyy') = 1983

--8: Hiển thị tên nhân viên, lương một năm (ANUAL_SAL ), thưởng sao cho lương lớn
--hơn thưởng và nghề nghiệp là SALEMAN, sắp theo thứ tự lương giảm dần và tên tăng dần
SELECT ENAME, (SAL * 12) AS ANUAL_SAL, COMM
FROM EMP
WHERE JOB = 'SALESMAN'
  AND SAL > COMM
ORDER BY SAL DESC, ENAME