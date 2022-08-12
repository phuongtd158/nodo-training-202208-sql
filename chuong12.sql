-- 1. Viết đoạn chương trình tìm kiếm các hàng trong bảng EMP với biến được đưa từ
-- ngoài vào là &1 dạng JOb_type(emp.job%type) và đưa ra thông báo thích hợp
-- vào bảng MESSAGES.

declare
    cursor c_Emp is
        select *
        from EMP;
    v_Emp       c_Emp%rowtype;
    total_count number(2) := 0;
begin
    open c_Emp;
    loop
        fetch c_Emp into v_Emp;
        exit when c_Emp%notfound;
        if (v_Emp.JOB = 'CLERK') then
            total_count := total_count + 1;
        end if;
    end loop;
    close c_Emp;
    insert into MESSAGES_PHUONGTD(NUMCOL1)
    values (total_count);
end;

SELECT *
FROM MESSAGES_PHUONGTD

-- 2. Viết đoạn chương trình ghi dữ liệu vào bảng MESSAGES với cột NUMCOL1 mang giá trị
--là 1 nếu là row 1 được Insert, 2 nếu row 2 được Insert... . Không được Insert những
--row có giá trị là 6 hoặc 8, thoát khỏi vòng lặp insert sau giá trị 10. Commit sau vòng lặp.
declare
    numcol1 number(2) := 0;
begin
    while numcol1 < 10
        loop
            numcol1 := numcol1 + 1;
            if (numcol1 = 6 or numcol1 = 8) then
                insert into MESSAGES_PHUONGTD(NUMCOL1)
                values (null);
            else
                insert into MESSAGES_PHUONGTD(NUMCOL1)
                values (numcol1);
            end if;
        end loop;
end;
--3. Liệt kê các cột ENAME, HIREDATE, SAL Với điều kiện EMPNO bằng giá trị biến
--EMPLOYEE_NO được đưa vào, sau đó kiểm tra:
--1.1 Có phải mức lương lớn hơn 1200
--1.2 Tên nhân viên có phải có chứa chữ T
--1.3 ngày gia nhập cơ quan có phải là tháng 10 (DEC)
--và đưa giá trị kiểm tra này vào bảng message cột charcol1 (thử với các giá trị 7654, 7369, 7900, 7876)
declare
    cursor c_Emp is
        select ENAME, HIREDATE, SAL
        from EMP
        where EMPNO = 7369;
    v_Emp c_Emp%rowtype;
    mess  varchar2(100) := '';
begin
    open c_Emp;
    fetch c_Emp into v_Emp;
    if (v_Emp.SAL > 1200) then
        mess := 'Salary: ' || v_Emp.SAL || ' ';
    end if;
    if (v_Emp.ENAME like '%T%') then
        mess := mess || 'Name: ' || v_Emp.ENAME || ' ';
    end if;
    if (to_char(v_Emp.HIREDATE, 'MM') = 10) then
        mess := mess || 'Hiredate: ' || v_Emp.HIREDATE;
    end if;
    close c_Emp;
    insert into MESSAGES_PHUONGTD(CHARCOL2)
    values (mess);
end;

--4. Đưa vào vòng lặp v từ 1 đến 10 lệnh:
--UPDATE messages
--SET numcol2=100
--WHERE numcol1 = v;
--nếu bất kỳ một lần update nào đó có số lượng row >1 thì exit khỏi vòng lặp
-- update MESSAGES_PHUONGTD set NUMCOL1 = 2 where NUMCOL1 = 5
declare
    cursor c_mess is
        select NUMCOL1, count(NUMCOL1) as count_numcol1
        from MESSAGES_PHUONGTD
        where NUMCOL1 is not null
        group by NUMCOL1
        order by NUMCOL1;
    v_mess c_mess%rowtype;
    v      number(2) := 0;
begin
    open c_mess;
    while v < 10
        loop
            v := v + 1;
            fetch c_mess into v_mess;
            exit when c_mess%notfound;
            if (v_mess.count_numcol1 > 1) then
                return;
            else
                update MESSAGES_PHUONGTD set NUMCOL2 = 100 where NUMCOL1 = v;
            end if;
        end loop;
    close c_mess;
end;

create procedure proc_test(
    id in EMP.EMPNO%type
)
as
begin
    select *
    from EMP
    where EMPNO = id;
end;

drop procedure proc_test

declare
    id number(4) := 7654;
begin
    proc_test(id);
end;

-- select * from MESSAGES_PHUONGTD; select * from EMP
