
CREATE DATABASE DB_Booking;
USE DB_Booking;
Go
CREATE TABLE Khach_Hang
(
    Ma_khach_hang int Identity (1,1),
    Ten_tai_khoan varchar(50)  not null unique,
    Mat_khau      Varchar(20)  not null,
    Ho_ten        Nvarchar(50) not null,
    Gioi_tinh     bit          not null,
    Ngay_sinh     date         not null,
    Dia_chi       Nvarchar(100),
    Email         Varchar(50)  not null unique,
    SDT           Varchar(10),
    PRIMARY KEY (Ma_khach_hang)
)

    GO
CREATE TABLE Khach_san
(
    Ma_khach_san  int Identity (1,1),
    Ten_khach_san NVarchar(50)  not null,
    Dia_chi       Nvarchar(100) not null,
    Thanh_pho     NVarChar(50)  not null,
    Mo_ta         NVarchar(100),
    Xep_hang      Decimal(2, 1) not null,
    Hinh		  Nvarchar(250),
    PRIMARY KEY (Ma_khach_san)
)

    GO
CREATE TABLE Phong
(
    Ma_phong     int identity (1,1),
    Ma_khach_san INT,
    So_phong     VARCHAR(10) NOT NULL,
    Kieu         VARCHAR(50),
    Gia          Float       NOT NULL,
    Mo_ta        NVarchar(100),
    Trang_thai   bit         not null,
    Hinh		  Nvarchar(250),
    PRIMARY KEY (Ma_phong),
    FOREIGN KEY (Ma_khach_san) REFERENCES Khach_san (Ma_khach_san),
);


GO
CREATE TABLE Dat_phong
(
    Ma_dat_phong  INT Identity (1,1),
    Ma_khach_hang INT,
    Ma_khuyen_mai INT,
    Tong_tien     Float NOT NULL,
    Trang_thai    bit   not null,
    PRIMARY KEY (Ma_dat_phong),
    FOREIGN KEY (Ma_khach_hang) REFERENCES Khach_hang (Ma_khach_hang),
    FOREIGN KEY (Ma_khuyen_mai) REFERENCES Khuyen_mai (Ma_khuyen_mai)
)

drop table Dat_phong
    GO
CREATE TABLE Danh_Gia
(
    Ma_danh_gia   INT Identity (1,1),
    Ma_khach_hang INT,
    Ma_khach_san  INT,
    Danh_gia      INT CHECK (Danh_gia >= 1 AND Danh_gia <= 5),
    Binh_luan     NVARCHAR(255),
    Ngay_danh_gia DateTime,
    PRIMARY KEY (Ma_danh_gia),
    FOREIGN KEY (Ma_khach_hang) REFERENCES Khach_Hang (Ma_khach_hang),
    FOREIGN KEY (Ma_khach_san) REFERENCES Khach_san (Ma_khach_san)
);
GO

CREATE TABLE Khuyen_mai
(
    Ma_khuyen_mai  INT Identity (1,1),
    Ten_khuyen_mai NVarchar(100) NOT NULL,
    Mo_ta          NVarchar(200),
    Ngay_bat_dau   DATE          NOT NULL,
    Ngay_ket_thuc  DATE          NOT NULL,
    Muc_giam       Decimal(5, 2) NOT NULL CHECK (Muc_giam >= 0 AND Muc_giam <= 100),
    PRIMARY KEY (Ma_khuyen_mai)
);
GO

CREATE TABLE Dich_vu
(
    Ma_dich_vu   INT Identity (1,1),
    Ma_khach_san INT           NOT NULL,
    Ten_dich_vu  NVarchar(100) NOT NULL,
    Mo_ta        NVarchar(200),
    Gia          Float         NOT NULL,
    PRIMARY KEY (Ma_dich_vu),
    FOREIGN KEY (Ma_khach_san) REFERENCES Khach_san (Ma_khach_san)

);
GO

CREATE TABLE Hinh_anh
(
    Ma_khach_san int,
    hinh         varchar(255),
    FOREIGN KEY (Ma_khach_san) REFERENCES Khach_san (Ma_khach_san)
)
CREATE TABLE Chi_tiet_dat_phong(
                                   Ma_chi_tiet_dat_phong INT IDENTITY(1,1),
                                   Ma_dat_phong INT ,
                                   Ma_phong INT,
                                   Ngay_den DATE,
                                   Ngay_tra DATE,
                                   Gia_phong FLoat,
                                   PRIMARY KEY(Ma_chi_tiet_dat_phong),
                                   FOREIGN KEY (Ma_phong) REFERENCES Phong (Ma_phong),
                                   FOREIGN KEY (Ma_dat_phong) REFERENCES Dat_phong (Ma_dat_phong)
)

Create table Account(
                        Ma_Account int Identity (1,1) PRIMARY KEY,
                        Ten_tai_khoan varchar(50),
                        Mat_khau      Varchar(20),
                        SDT           Varchar(10),
                        Email         Varchar(50)
)
    INSERT INTO Account
(Ten_tai_khoan, Mat_khau, SDT, Email)
VALUES ('kkq01', N'123', N'0919925302', N'kieukienquocvn@gmail.com');

select*from Account
-- Insert nè
    INSERT INTO Khach_san
(Ten_khach_san, Dia_chi, Thanh_pho, Mo_ta, Xep_hang,Hinh)
VALUES (N'Khách sạn Sài Gòn', N'123 Lê Lai, Q.1', N'TP. Hồ Chí Minh', N'Khách sạn 5 sao', 5.0,N'img1.jpg'),
    (N'Khách sạn Da Lat', N'45 Nguyễn Thi Minh Khai, TP. Đà Lạt', N'Lâm Đồng', N'Khách sạn 4 sao', 4.5,N'img2.jpg'),
    (N'Khách sạn Vinh', N'100 Quang Trung, TP. Vinh', N'Nghệ An', N'Khách sạn 3 sao', 3.0,N'img3.jpg'),
    (N'Khách sạn Nha Trang', N'258 Trần Phú, TP. Nha Trang', N'Khánh Hòa', N'Khách sạn bể bơi', 4.0,N'img4.jpg'),
    (N'Khách sạn Trà Vinh', N'12 Trần Hưng Đạo, TP. Trà Vinh', N'Trà Vinh', N'Khách sạn giá rẻ', 2.5,N'img5.jpg')

select*from Khach_san
    INSERT INTO Phong
(Ma_khach_san, So_phong, Kieu, Gia, Mo_ta, Trang_thai,Hinh)
VALUES (1, 'P101', N'Phòng VIP', 500, N'Có cửa sổ ra biển', 1,'img1.jpg'),
    (1, 'P102', N'Phòng thường', 300, N'Có ghế salon', 0,'401099204.jpg'),
    (2, 'P201', N'Phòng đôi', 400, N'Có 1 giường đôi', 1,'401099211.jpg'),
    (2, 'P202', N'Phòng VIP', 600, N'Có bách khoa thư', 1,'img1.jpg'),
    (3, 'P301', N'Phòng gia đình', 1000, N'Có 2 giường đơn', 0,'img1.jpg'),
    (3, 'P302', N'Phòng đôi', 500, N'Có 2 giường đôi', 1,'img5.jpg'),
    (4, 'P401', N'Phòng đơn', 200, N'Có 1 giường đơn', 1,'img5.jpg'),
    (4, 'P402', N'Phòng VIP', 800, N'Có bể bơi riêng', 0,'img6.jpg'),
    (5, 'P501', N'Phòng gia đình', 1200, N'Có 3 giường đơn', 1,'sp1.webp'),
    (5, 'P502', N'Phòng đôi', 700, N'Có 2 giường đôi', 0,'401099211.jpg'),
    (1, 'P201', N'Phòng đôi', 400, N'Có 1 giường đôi', 1,'401099211.jpg'),
    (1, 'P202', N'Phòng VIP', 600, N'Có bách khoa thư', 1,'img1.jpg'),
    (1, 'P301', N'Phòng gia đình', 1000, N'Có 2 giường đơn', 0,'img1.jpg'),
    (1, 'P302', N'Phòng đôi', 500, N'Có 2 giường đôi', 1,'img5.jpg'),
    (1, 'P401', N'Phòng đơn', 200, N'Có 1 giường đơn', 1,'img5.jpg'),
    (1, 'P402', N'Phòng VIP', 800, N'Có bể bơi riêng', 0,'img6.jpg'),
    (1, 'P501', N'Phòng gia đình', 1200, N'Có 3 giường đơn', 1,'sp1.webp'),
    (1, 'P502', N'Phòng đôi', 700, N'Có 2 giường đôi', 0,'401099211.jpg'),
    (2, 'P101', N'Phòng VIP', 500, N'Có cửa sổ ra biển', 1,'img1.jpg'),
    (2, 'P102', N'Phòng thường', 300, N'Có ghế salon', 0,'401099204.jpg'),
    (2, 'P301', N'Phòng gia đình', 1000, N'Có 2 giường đơn', 0,'img1.jpg'),
    (2, 'P302', N'Phòng đôi', 500, N'Có 2 giường đôi', 1,'img5.jpg'),
    (2, 'P401', N'Phòng đơn', 200, N'Có 1 giường đơn', 1,'img5.jpg'),
    (2, 'P402', N'Phòng VIP', 800, N'Có bể bơi riêng', 0,'img6.jpg'),
    (2, 'P501', N'Phòng gia đình', 1200, N'Có 3 giường đơn', 1,'sp1.webp'),
    (3, 'P101', N'Phòng VIP', 500, N'Có cửa sổ ra biển', 1,'img1.jpg'),
    (3, 'P102', N'Phòng thường', 300, N'Có ghế salon', 0,'401099204.jpg'),
    (3, 'P201', N'Phòng đôi', 400, N'Có 1 giường đôi', 1,'401099211.jpg'),
    (3, 'P202', N'Phòng VIP', 600, N'Có bách khoa thư', 1,'img1.jpg'),
    (3, 'P401', N'Phòng đơn', 200, N'Có 1 giường đơn', 1,'img5.jpg'),
    (3, 'P402', N'Phòng VIP', 800, N'Có bể bơi riêng', 0,'img6.jpg'),
    (3, 'P501', N'Phòng gia đình', 1200, N'Có 3 giường đơn', 1,'sp1.webp'),
    (3, 'P502', N'Phòng đôi', 700, N'Có 2 giường đôi', 0,'401099211.jpg'),
    (4, 'P101', N'Phòng VIP', 500, N'Có cửa sổ ra biển', 1,'img1.jpg'),
    (4, 'P102', N'Phòng thường', 300, N'Có ghế salon', 0,'401099204.jpg'),


INSERT INTO Dich_vu (Ma_khach_san, Ten_dich_vu, Mo_ta, Gia)
VALUES
    (1, 'Dịch vụ ăn uống', 'Nhà hàng, quầy bar', 150.00),
    (1, 'Dịch vụ giặt ủi', 'Giặt là nhanh chóng và tiện lợi', 50.00),
    (2, 'Dịch vụ spa', 'Trải nghiệm nghỉ dưỡng thư giãn', 300.00),
    (2, 'Dịch vụ hồ bơi', 'Hồ bơi rộng rãi và sạch sẽ', 80.00),
    (3, 'Dịch vụ phòng gym', 'Phòng tập đầy đủ trang thiết bị', 100.00),
    (3, 'Dịch vụ golf', 'Sân golf 18 lỗ với cảnh quan đẹp', 500.00);

INSERT INTO Khach_Hang (Ten_tai_khoan, Mat_khau, Ho_ten, Gioi_tinh, Ngay_sinh, Dia_chi, Email, SDT)
VALUES
('user1', '123', 'user1',1,'1-1-2004', 'Tp.Hồ Chí Minh', 'user1@gmail.com','0123456789'),
('baor123','123','Nguyễn Văn Hoàng Bảo',1,'11-29-2004','Quảng Trị','baonvhps343@fpt.edu.vn','0123762465')

--demo truy vấn

SELECT p.* FROM Phong p INNER JOIN Khach_san k ON p.Ma_khach_san = k.Ma_khach_san WHERE k.Ten_khach_san = N'Khách sạn Sài Gòn'

SELECT * FROM Phong p WHERE p.gia <400

