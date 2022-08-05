----------------------------4----------------------------
--1: Liệt kê tên nhân viên, mã phòng ban và lương nhân viên được tăng 15% (PCTSAL)
SELECT DEPTNO, ENAME, SAL * 1.5 as PCTSAL
FROM EMP

--2Viết câu lệnh hiển thị như sau: EMPLOYEE_AND_JOB
SELECT RPAD(ename, 10, '*') || '  ' || LPAD(JOB, 10, '*')
FROM EMP
WHERE JOB IS NOT NULL

--3: Viết câu lệnh hiển thị như sau: EMPLOYEE
SELECT CONCAT(ENAME, ' ' || '(' || NLS_INITCAP(JOB) || ')') EMPLOYEE
FROM EMP
WHERE JOB IS NOT NULL

--4
SELECT ENAME, DEPTNO, NLS_INITCAP(JOB) as JOB
FROM EMP
WHERE DEPTNO IS NOT NULL
  AND JOB IS NOT NULL
  AND DEPTNO = 30

--5: Tìm ngày thứ 6 đầu tiên cách 2 tháng so với ngày hiện tại hiển thị ngày dưới dạng 09 February 1990
SELECT TO_CHAR(NEXT_DAY(ADD_MONTHS(CURRENT_DATE, 2), 'FRIDAY'), 'dd MONTH yyyy') DAY
FROM DUAL

--6
SELECT ENAME, TO_CHAR(HIREDATE, 'month, DDspth yyyy')
FROM EMP
WHERE HIREDATE IS NOT NULL

--7: Hiển thị tên nhân viên, ngày gia nhập công ty, ngày xét nâng lương (sau ngày gia
--nhập công ty 1 năm), sắp xếp theo thứ tự ngày xét nâng lương.
SELECT ENAME, TO_CHAR(HIREDATE, 'dd-MM-yyyy'), TO_CHAR(ADD_MONTHS(HIREDATE, 12), 'dd-MM-yyyy') REVIEW
FROM EMP
WHERE HIREDATE IS NOT NULL
ORDER BY REVIEW

--8: Hiển thị tên nhân viên và lương dưới dạng
SELECT ENAME,
       (
           CASE
               WHEN SAL < 1500 THEN 'BELOW 1500'
               WHEN SAL = 1500 THEN 'On Target'
               ELSE TO_CHAR(SAL)
               END
           ) as SALARY
FROM EMP
WHERE SAL IS NOT NULL

--9. Cho biết thứ của ngày hiện tại
SELECT TO_CHAR(CURRENT_DATE, 'DAY') as DAY
FROM DUAL

--10:Đưa chuỗi dưới dạng nn/nn, kiểm tra nếu khúng khuôn dạng trả lời là YES, ngược lại
--là NO. Kiểm tra với các chuỗi 12/34, 01/1a, 99\88

SELECT DECODE("nn/nn", 'YES', 'NO')
FROM DUAL

--11:. Hiển thị tên nhân viên, ngày gia nhập công ty, ngày lĩnh lương sao cho ngày lĩnh
--lương phải vào thứ 6, nhân viên chỉ được nhận lương sau ít nhất 15 ngày làm việc tại
--công ty, sắp xếp theo thứ tự ngày gia nhập công ty
SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE + 15, 'FRIDAY') as SALARY_DAY
FROM EMP
WHERE (CURRENT_DATE - HIREDATE) >= 15
ORDER BY HIREDATE

--4.5.2. Hàm trên nhóm dữ liệu
--1. Tìm lương thấp nhất, lớn nhất và lương trung bình của tất cả các nhân viên
SELECT MIN(SAL) MIN_SALARY
FROM EMP

SELECT MAX(SAL) MAX_SALARY
FROM EMP

SELECT AVG(SAL) AVG_SALARY
FROM EMP

--2. Tìm lương nhỏ nhất và lớn của mỗi loại nghề nghiệp
SELECT JOB, MIN(SAL) MIN_SALARY, MAX(SAL) MAX_SALARY
FROM EMP
WHERE JOB IS NOT NULL
GROUP BY JOB

--3. Tìm xem có bao nhiêu giám đốc trong danh sách nhân viên.
SELECT COUNT(*) as COUNT
FROM EMP
WHERE JOB = 'MANAGER'

--4. Tìm tất cả các phòng ban mà số nhân viên trong phòng >3
SELECT DEPTNO, COUNT(EMPNO) as COUNT_EMP
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(EMPNO) > 3

--5. Tìm ra mức lương nhỏ nhất của mỗi nhân viên làm việc cho một giám đốc nào đó
--sắp xếp theo thứ tự tăng dần của mức lương.
select DEPTNO, MIN(SAL) as MIN_SALARY
from EMP
where DEPTNO in (select DEPTNO from EMP where JOB = 'MANAGER')
group by DEPTNO;


