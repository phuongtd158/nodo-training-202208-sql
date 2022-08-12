--A: Danh sách bản
CREATE TABLE PHUONGTD_NHAXUATBAN
(
    ID         number(4)     not null
        constraint PK_PHUONGTD_NHAXUATBAN primary key,
    MA_NXB     number(4)     not null
        constraint UNQ_PHUONGTD_NHAXUATBAN unique,
    TEN_NXB    varchar2(100) not null,
    TRANG_THAI number(1),
    DIA_CHI    varchar2(255),
    MO_TA      varchar2(255)
)

create table PHUONGTD_TACGIA
(
    ID          number(4)     not null
        constraint PK_PHUONGTD_TACGIA primary key,
    MA_TAC_GIA  number(4)     not null
        constraint UNQ_MA_TG_PHUONGTD_TACGIA unique,
    TEN_TAC_GIA varchar2(100) not null,
    SDT         varchar2(12)  not null
        constraint UNQ_SDT_PHUONGTD_TAC_GIA unique,
    DIACHI      varchar2(255),
    MOTA        varchar2(255)
)

create table PHUONGTD_SACH
(
    ID                 number(4)    not null
        constraint PK_PHUONGTD_SACH primary key,
    MA_SACH            number(4)    not null
        constraint UNQ_MA_SACH_PHUONGTD_SACH unique,
    MA_NXB             number(4)
        constraint FK_NXB references PHUONGTD_NHAXUATBAN (ID),
    MA_TAC_GIA         number(4)
        constraint FK_MA_TAC_GIA references PHUONGTD_TACGIA (ID),
    CHU_DE             varchar2(50) not null,
    NAM_XUAT_BAN       date,
    MO_TA              varchar2(255),
    SO_LUONG_CON_LAI   number(4),
    SO_LUONG_SACH_MUON number(4),
    TONG_SO_SACH       number(5)
)

create table PHUONGTD_BANDOC
(
    ID                 number(4)    not null
        constraint PK_PHUONGTD_BANDOC primary key,
    MA_BAN_DOC         number(4)    not null
        constraint UNQ_MA_BAN_DOC_PHUONGTD_BANDOC unique,
    TEN_BAN_DOC        varchar2(50) not null,
    SDT                varchar2(12) not null
        constraint UNQ_SDT_PHUONGTD_BANDOC unique,
    DIA_CHI            varchar2(100),
    NGAY_SINH          date,
    NGAY_TAO_TAI_KHOAN date,
    HANG               number(1)
)

create table PHUONGTD_MUONSACH
(
    ID            number(4) not null
        constraint PK_PHUONGTD_MUONSACH primary key,
    MA_BAN_DOC    number(4)
        constraint FK_BAN_DOC_PHUONGTD_MUONSACH references PHUONGTD_BANDOC (ID),
    MA_SACH       number(4)
        constraint FK_MA_SACH_PHUONGTD_SACH references PHUONGTD_SACH (ID),
    SO_LUONG      number(1),
    NGAY_GIO_MUON date,
    NGAY_GIO_TRA  date,
    TRANG_THAI    number(1),
    GHI_CHU       varchar2(100)
)

--1. Viết script tạo cấu trúc các bảng. Đối với bảng Mượn Sách cần đánh partition trên trường ngày giờ mượn,
-- và 2 local index: 1 index trên trường id bạn đọc, 1 index trên id sách. Tên indexes theo cấu trúc : TENBANG_IDX_TENTRUONG

create index PHUONGTD_IDX_MA_BAN_DOC on PHUONGTD_MUONSACH (MA_BAN_DOC);
create index PHUONGTD_IDX_MA_SACH on PHUONGTD_MUONSACH (MA_SACH);

--2.Viết script tạo sequence cho mỗi bảng. Sequence được dùng để insert trường Id cho các bảng. Tên sequence theo cấu trúc : TENBANG_SEQ

create sequence PHUONGTD_NHAXUATBAN_SEQ increment by 1 start with 1 nocycle;
create sequence PHUONGTD_PHUONGTD_TACGIA_SEQ increment by 1 start with 1 nocycle;
create sequence PHUONGTD_PHUONGTD_SACH_SEQ increment by 1 start with 1 nocycle;
create sequence PHUONGTD_PHUONGTD_BANDOC_SEQ increment by 1 start with 1 nocycle;
create sequence PHUONGTD_PHUONGTD_MUONSACH_SEQ increment by 1 start with 1 nocycle;

--3.Viết script tạo unique index cho các bảng nếu có.

create unique index UIDX_PHUONGTD_NHAXUATBAN on PHUONGTD_NHAXUATBAN (MA_NXB);
create unique index UIDX_PHUONGTD_TACGIA on PHUONGTD_TACGIA (MA_TAC_GIA);
create unique index UIDX_PHUONGTD_SACH on PHUONGTD_SACH (MA_SACH);
create unique index UIDX_PHUONGTD_BANDOC on PHUONGTD_BANDOC (MA_BAN_DOC);

--4. Viết script insert dữ liệu mẫu cho tất cả các bảng

insert into PHUONGTD_NHAXUATBAN(ID, MA_NXB, TEN_NXB, TRANG_THAI, DIA_CHI, MO_TA)
values (PHUONGTD_NHAXUATBAN_SEQ.nextval, 1000, 'Kim Dong', 1, 'Ha Noi', 'Day la mo ta !');
insert into PHUONGTD_NHAXUATBAN(ID, MA_NXB, TEN_NXB, TRANG_THAI, DIA_CHI, MO_TA)
values (PHUONGTD_NHAXUATBAN_SEQ.nextval, 1001, 'Viet Hien', 1, 'Bac Ninh', 'Day la mo ta 2!');
insert into PHUONGTD_NHAXUATBAN(ID, MA_NXB, TEN_NXB, TRANG_THAI, DIA_CHI, MO_TA)
values (PHUONGTD_NHAXUATBAN_SEQ.nextval, 1002, 'Tat Hoa', 1, 'Thanh Hoa', 'Day la mo ta 3!');
insert into PHUONGTD_NHAXUATBAN(ID, MA_NXB, TEN_NXB, TRANG_THAI, DIA_CHI, MO_TA)
values (PHUONGTD_NHAXUATBAN_SEQ.nextval, 1003, 'Duc Phuong', 1, 'Vinh Phuc', 'Day la mo ta 4!');
insert into PHUONGTD_NHAXUATBAN(ID, MA_NXB, TEN_NXB, TRANG_THAI, DIA_CHI, MO_TA)
values (PHUONGTD_NHAXUATBAN_SEQ.nextval, 1004, 'Minh Thuy', 1, 'Ha Noi', 'Day la mo ta 5!');

insert into PHUONGTD_TACGIA(ID, MA_TAC_GIA, TEN_TAC_GIA, SDT, DIACHI, MOTA)
values (PHUONGTD_PHUONGTD_TACGIA_SEQ.nextval, 1000, 'Nam Cao', '012345678', 'Ninh Binh', 'Khong co mo ta');
insert into PHUONGTD_TACGIA(ID, MA_TAC_GIA, TEN_TAC_GIA, SDT, DIACHI, MOTA)
values (PHUONGTD_PHUONGTD_TACGIA_SEQ.nextval, 1001, 'Xuan Quynh', '012345676', 'Viet Nam', 'Khong co mo ta');
insert into PHUONGTD_TACGIA(ID, MA_TAC_GIA, TEN_TAC_GIA, SDT, DIACHI, MOTA)
values (PHUONGTD_PHUONGTD_TACGIA_SEQ.nextval, 1002, 'To Huu', '012345674', 'Binh Dinh', 'Khong co mo ta');
insert into PHUONGTD_TACGIA(ID, MA_TAC_GIA, TEN_TAC_GIA, SDT, DIACHI, MOTA)
values (PHUONGTD_PHUONGTD_TACGIA_SEQ.nextval, 1003, 'Xuan Dieu', '012345673', 'Binh Dinh', 'Khong co mo ta');
insert into PHUONGTD_TACGIA(ID, MA_TAC_GIA, TEN_TAC_GIA, SDT, DIACHI, MOTA)
values (PHUONGTD_PHUONGTD_TACGIA_SEQ.nextval, 1004, 'Quang Dung', '012345671', 'Ha Noi', 'Khong co mo ta');

insert into PHUONGTD_SACH(ID, MA_SACH, MA_NXB, MA_TAC_GIA, CHU_DE, NAM_XUAT_BAN, MO_TA, SO_LUONG_CON_LAI,
                          SO_LUONG_SACH_MUON, TONG_SO_SACH)
values (PHUONGTD_PHUONGTD_SACH_SEQ.nextval, 1000, 2, 2, 'Truyen', to_date('2020-05-01', 'yyyy-MM-dd'), 'Khong co', 1000,
        400, 1400);
insert into PHUONGTD_SACH(ID, MA_SACH, MA_NXB, MA_TAC_GIA, CHU_DE, NAM_XUAT_BAN, MO_TA, SO_LUONG_CON_LAI,
                          SO_LUONG_SACH_MUON, TONG_SO_SACH)
values (PHUONGTD_PHUONGTD_SACH_SEQ.nextval, 1001, 3, 5, 'Ky su', to_date('2021-07-01', 'yyyy-MM-dd'), 'Khong co', 1500,
        400, 1900);
insert into PHUONGTD_SACH(ID, MA_SACH, MA_NXB, MA_TAC_GIA, CHU_DE, NAM_XUAT_BAN, MO_TA, SO_LUONG_CON_LAI,
                          SO_LUONG_SACH_MUON, TONG_SO_SACH)
values (PHUONGTD_PHUONGTD_SACH_SEQ.nextval, 1003, 4, 4, 'Chinh tri', to_date('2020-08-01', 'yyyy-MM-dd'), 'Khong co',
        700, 400, 1100);
insert into PHUONGTD_SACH(ID, MA_SACH, MA_NXB, MA_TAC_GIA, CHU_DE, NAM_XUAT_BAN, MO_TA, SO_LUONG_CON_LAI,
                          SO_LUONG_SACH_MUON, TONG_SO_SACH)
values (PHUONGTD_PHUONGTD_SACH_SEQ.nextval, 1004, 5, 6, 'Co tich', to_date('2021-05-08', 'yyyy-MM-dd'), 'Khong co', 600,
        400, 1000);
insert into PHUONGTD_SACH(ID, MA_SACH, MA_NXB, MA_TAC_GIA, CHU_DE, NAM_XUAT_BAN, MO_TA, SO_LUONG_CON_LAI,
                          SO_LUONG_SACH_MUON, TONG_SO_SACH)
values (PHUONGTD_PHUONGTD_SACH_SEQ.nextval, 1007, 5, 6, 'Co tich 2', to_date('2021-05-08', 'yyyy-MM-dd'), 'Khong co',
        600,
        300, 900);
insert into PHUONGTD_SACH(ID, MA_SACH, MA_NXB, MA_TAC_GIA, CHU_DE, NAM_XUAT_BAN, MO_TA, SO_LUONG_CON_LAI,
                          SO_LUONG_SACH_MUON, TONG_SO_SACH)
values (PHUONGTD_PHUONGTD_SACH_SEQ.nextval, 1005, 6, 7, 'Than thoai', to_date('2021-11-01', 'yyyy-MM-dd'), 'Khong co',
        700, 200, 500);
insert into PHUONGTD_SACH(ID, MA_SACH, MA_NXB, MA_TAC_GIA, CHU_DE, NAM_XUAT_BAN, MO_TA, SO_LUONG_CON_LAI,
                          SO_LUONG_SACH_MUON, TONG_SO_SACH)
values (PHUONGTD_PHUONGTD_SACH_SEQ.nextval, 1006, 6, 7, 'Thoan thoai hy lap', to_date('2021-11-01', 'yyyy-MM-dd'),
        'Khong co',
        800, 100, 900);

insert into PHUONGTD_BANDOC(ID, MA_BAN_DOC, TEN_BAN_DOC, SDT, DIA_CHI, NGAY_SINH, NGAY_TAO_TAI_KHOAN, HANG)
values (PHUONGTD_PHUONGTD_BANDOC_SEQ.nextval, 1000, 'Tran Duc Phuong', '012345678', 'Vinh Phuc',
        to_date('2002-08-15', 'yyyy-MM-dd'),
        to_date('2020-08-15', 'yyyy-MM-dd'), 1);
insert into PHUONGTD_BANDOC(ID, MA_BAN_DOC, TEN_BAN_DOC, SDT, DIA_CHI, NGAY_SINH, NGAY_TAO_TAI_KHOAN, HANG)
values (PHUONGTD_PHUONGTD_BANDOC_SEQ.nextval, 1001, 'Nguyen Viet Hien', '012345672', 'Ban Ninh',
        to_date('2001-03-15', 'yyyy-MM-dd'),
        to_date('2021-01-15', 'yyyy-MM-dd'), 2);
insert into PHUONGTD_BANDOC(ID, MA_BAN_DOC, TEN_BAN_DOC, SDT, DIA_CHI, NGAY_SINH, NGAY_TAO_TAI_KHOAN, HANG)
values (PHUONGTD_PHUONGTD_BANDOC_SEQ.nextval, 1002, 'Do Tat Hoa', '012345676', 'Thanh Hoa',
        to_date('2002-08-15', 'yyyy-MM-dd'),
        to_date('2022-02-15', 'yyyy-MM-dd'), 3);

insert into PHUONGTD_MUONSACH(ID, MA_BAN_DOC, MA_SACH, SO_LUONG, NGAY_GIO_MUON, NGAY_GIO_TRA, TRANG_THAI, GHI_CHU)
values (PHUONGTD_PHUONGTD_MUONSACH_SEQ.nextval, 2, 4, 5, to_date('2022-02-15', 'yyyy-MM-dd'),
        to_date('2022-02-20', 'yyyy-MM-dd'), 1, 'Khong');
insert into PHUONGTD_MUONSACH(ID, MA_BAN_DOC, MA_SACH, SO_LUONG, NGAY_GIO_MUON, NGAY_GIO_TRA, TRANG_THAI, GHI_CHU)
values (PHUONGTD_PHUONGTD_MUONSACH_SEQ.nextval, 3, 6, 2, to_date('2021-05-15', 'yyyy-MM-dd'),
        to_date('2021-05-21', 'yyyy-MM-dd'), 1, 'Khong');
insert into PHUONGTD_MUONSACH(ID, MA_BAN_DOC, MA_SACH, SO_LUONG, NGAY_GIO_MUON, NGAY_GIO_TRA, TRANG_THAI, GHI_CHU)
values (PHUONGTD_PHUONGTD_MUONSACH_SEQ.nextval, 4, 7, 4, to_date('2022-02-10', 'yyyy-MM-dd'),
        to_date('2022-02-22', 'yyyy-MM-dd'), 1, 'Khong');
insert into PHUONGTD_MUONSACH(ID, MA_BAN_DOC, MA_SACH, SO_LUONG, NGAY_GIO_MUON, NGAY_GIO_TRA, TRANG_THAI, GHI_CHU)
values (PHUONGTD_PHUONGTD_MUONSACH_SEQ.nextval, 4, 9, 1, to_date('2022-08-04', 'yyyy-MM-dd'),
        to_date('2022-08-12', 'yyyy-MM-dd'), 1, 'Khong');
insert into PHUONGTD_MUONSACH(ID, MA_BAN_DOC, MA_SACH, SO_LUONG, NGAY_GIO_MUON, NGAY_GIO_TRA, TRANG_THAI, GHI_CHU)
values (PHUONGTD_PHUONGTD_MUONSACH_SEQ.nextval, 2, 9, 5, to_date('2022-08-01', 'yyyy-MM-dd'),
        to_date('2022-08-12', 'yyyy-MM-dd'), 1, 'Khong');

--5.	Hiển thị dách sách tác giả và tổng số lượng sách của tác giả gồm các trường thông tin:
--Mã Tác Giả, Tên Tác Giả, Chủ Đề, Số Lượng Sách
--Sắp xếp theo số lượng sách giảm dần
select a.MA_TAC_GIA, a.TEN_TAC_GIA, b.CHU_DE, TONG_SO_SACH
from PHUONGTD_TACGIA a,
     PHUONGTD_SACH b
where a.ID = b.MA_TAC_GIA
order by TONG_SO_SACH desc

-- 6.	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất gồm các trường thông tin:
-- Mã Sách, Tên Sách, Tên Nhà Xuất Bản, Tên Tác Giả, Chủ Đề, Năm Xuất Bản, Số Lượng Còn Lại, Số Lượng Đã Mượn, Tổng Số
select *
from (
         select a.MA_SACH,
                a.TEN_SACH,
                b.TEN_NXB,
                c.TEN_TAC_GIA,
                a.CHU_DE,
                a.NAM_XUAT_BAN,
                a.SO_LUONG_CON_LAI,
                a.SO_LUONG_SACH_MUON,
                a.TONG_SO_SACH
         from PHUONGTD_SACH a,
              PHUONGTD_NHAXUATBAN b,
              PHUONGTD_TACGIA c
         where a.MA_NXB = b.id
           and a.MA_TAC_GIA = c.id
     )
where ROWNUM < 11
-- 7.	Hiển thị  thông tin bạn đọc và sách được mượn từ ngày đầu tháng hiện tại đến thời điểm hiện tại.
-- Mã Bạn Đọc, Tên Bạn Đọc, Mã Sách, Tên Sách, Ngày Giờ Mượn, Số lượng
-- Sắp xếp theo ngày giờ mượn giảm dần, Tên bạn đọc tăng dần.

select a.MA_BAN_DOC, a.TEN_BAN_DOC, b.MA_SACH, b.TEN_SACH, c.NGAY_GIO_MUON, c.SO_LUONG
from PHUONGTD_BANDOC a,
     PHUONGTD_SACH b,
     PHUONGTD_MUONSACH c
where a.ID = c.MA_BAN_DOC
  and b.ID = c.MA_SACH
  and c.NGAY_GIO_MUON between to_date(to_char(trunc(sysdate, 'month'), 'yyyy-MM-dd'), 'yyyy-MM-dd')
    and to_date(to_char(current_date, 'yyyy-MM-dd'), 'yyyy-MM-dd')
order by c.NGAY_GIO_MUON desc, a.TEN_BAN_DOC asc

-- 8.	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất tính từ đầu năm 2022
-- Mã Sách, Tên Sách, Số Lượng Đã Được Mượn.

select *
from (
         select a.MA_SACH, b.TEN_SACH, sum(a.SO_LUONG) as SO_LUONG_SACH_MUON
         from PHUONGTD_MUONSACH a,
              PHUONGTD_SACH b
         where a.MA_SACH = b.ID
           and to_char(a.NGAY_GIO_MUON, 'yyyy') >= 2022
         group by a.MA_SACH, b.TEN_SACH
         order by SO_LUONG_SACH_MUON desc
     )
where ROWNUM < 11

-- 9.	Hiển thị danh sách bạn đọc và số lần mượn sách tính từ đầu năm 2022 sắp xếp theo tên bạn đọc tăng dần:
-- Mã Bạn Đọc, Tên Bạn Đọc, Số Lần Mượn
select a.MA_BAN_DOC, b.TEN_BAN_DOC, count(a.MA_BAN_DOC)
from PHUONGTD_MUONSACH a,
     PHUONGTD_BANDOC b
where a.MA_BAN_DOC = b.ID
  and to_char(a.NGAY_GIO_MUON, 'yyyy') >= 2022
group by a.MA_BAN_DOC, b.TEN_BAN_DOC
order by b.TEN_BAN_DOC asc

-- 10.	Hiển thị thông tin bạn đọc gồm có:
-- Mã Bạn Đọc, Tên Bạn Đọc, Tuổi (được tính dựa vào trường ngày sinh)

select a.MA_BAN_DOC, a.TEN_BAN_DOC, to_char(sysdate, 'yyyy') - to_char(a.NGAY_SINH, 'yyyy') as TUOI
from PHUONGTD_BANDOC a

-- 11.	Thống kê tổng số bạn đọc theo độ tuổi
-- Tuổi, Tổng số Bạn Đọc

select to_char(sysdate, 'yyyy') - to_char(a.NGAY_SINH, 'yyyy')        as TUOI,
       count(to_char(sysdate, 'yyyy') - to_char(a.NGAY_SINH, 'yyyy')) as TONG_SO_BAN_DOC
from PHUONGTD_BANDOC a
group by a.NGAY_SINH

-- 12.	Thống kê số lượng sách được xuất bản theo Nhà Xuất Bản, Theo năm xuất bản.
-- Năm Xuất Bản, Mã Nhà Xuất Bản,Tên Nhà Xuất Bản, Số Lượng Sách
-- Sắp xếp theo Năm xuất bản giảm dần, Tên Nhà xuất bản tăng dần.

select a.NAM_XUAT_BAN, a.MA_NXB, b.TEN_NXB, sum(a.TONG_SO_SACH) as TONG_SO_LUONG_SACH
from PHUONGTD_SACH a,
     PHUONGTD_NHAXUATBAN b
where a.MA_NXB = b.ID
group by a.NAM_XUAT_BAN, a.MA_NXB, b.TEN_NXB
order by a.NAM_XUAT_BAN desc, b.TEN_NXB

-- 13.	Hiển thị 5 quyển sách được các bạn đọc có độ tuổi từ 18 đến 25 mượn nhiều nhất tính từ đầu năm 2022. (Tính theo trường số lượng mượn của sách)
-- Mã Sách, Tên Sách, Số Lượng Được Mượn

select *
from (
         select a.MA_SACH, a.TEN_SACH, sum(a.SO_LUONG_SACH_MUON) as TONG_SO_LUONG
         from PHUONGTD_SACH a,
              PHUONGTD_BANDOC b,
              PHUONGTD_MUONSACH c
         where a.ID = c.MA_SACH
           and b.ID = c.MA_BAN_DOC
           and to_char(sysdate, 'yyyy') - to_char(b.NGAY_SINH, 'yyyy') between 18 and 25
         group by a.MA_SACH, a.TEN_SACH
         order by TONG_SO_LUONG desc
     )
where ROWNUM < 6

-- 14.	Hiển thị toàn bộ bạn đọc và sách mà bạn đọc đấy mượn, sẽ có bạn chưa mượn vẫn cần hiển thị và tên sách để là null.
-- Mã bạn đọc, tên ban đọc, tên sách

select a.MA_BAN_DOC, a.TEN_BAN_DOC, c.TEN_SACH
from PHUONGTD_BANDOC a
         left join PHUONGTD_MUONSACH b on a.ID = b.MA_BAN_DOC
         left join PHUONGTD_SACH c on b.MA_SACH = c.ID

