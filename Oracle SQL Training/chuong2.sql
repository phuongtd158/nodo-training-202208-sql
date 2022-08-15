--1: Chọn toàn bộ thông tin trong bảng SALGRADE
SELECT DISTINCT *
FROM SALGRADE;

--2: Chọn toàn bộ thông tin trong bảng EMP
SELECT DISTINCT *
FROM EMP;

--3: Hiển thị mọi loại nghề nghiệp
SELECT DISTINCT *
FROM EMP
WHERE JOB = 'ANALYST'
   OR JOB = 'CLERK'
   OR JOB = 'MANAGER'
   OR JOB = 'PRESIDENT'
   OR JOB = 'SALESMAN';

--4: Hiển thị tên nhân viên và thu nhập trong một năm (REMUNERATION)
SELECT DISTINCT ENAME, (SAL * 12) as REMUNERATION
FROM EMP
WHERE SAL IS NOT NULL;

--5: Hiển thị theo nội dung dưới đây Who, what and when
SELECT DISTINCT ENAME
                    || ' HAS HELP THE POSITION OF ' || JOB
                    || ' IN DEPT ' || DEPTNO
                    || ' SINCE ' || HIREDATE
FROM EMP;


--6: Hiển thị cấu trúc bảng emp;
DESCRIBE EMP;

--7: Thay đổi nhãn và định dạng hiển thị của cột sal và hiredate trong bảng emp;
SELECT DISTINCT TO_CHAR(SAL, 'fm999G999G990')   as SALARY,
                TO_CHAR(HIREDATE, 'dd-MM-yyyy') as DATE_
FROM EMP