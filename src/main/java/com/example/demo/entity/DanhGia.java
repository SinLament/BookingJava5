package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Danh_Gia")
@Getter
@Setter
public class DanhGia {
    @Id
    @Column(name="Ma_danh_gia")
    private Integer maDanhGia;

    @Column(name="Ma_khach_hang")
    private Integer maKhachHang;

    @Column(name="Ma_khach_san")
    private Integer maKhachSan;

    @Column(name="Danh_gia")
    private Integer danhGia;

    @Column(name="Binh_luan")
    private String binhLuan;

    @Column(name="Ngay_danh_gia")
    private Date ngayDanhGia;
}
