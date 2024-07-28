package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Dat_phong")
public class DatPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_dat_phong")
    private Integer id;

    @Column(name = "Ma_khach_hang")
    private int maKhachHang;

    @Column(name = "Ma_khuyen_mai")
    private int maKhuyenMai;

    @Column(name = "Tong_tien")
    private float tongTien;

    @Column(name = "Trang_thai", nullable = false)
    @Convert(converter = BooleanConverter.class)
    private Boolean TrangThai;
}
