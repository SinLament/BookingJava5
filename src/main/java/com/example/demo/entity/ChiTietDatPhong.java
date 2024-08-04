package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Chi_tiet_dat_phong")
public class ChiTietDatPhong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_chi_tiet_dat_phong")
    private Integer id;

    private int maDatPhong;

    private int maPhong;

    private Date ngayDen;

    private Date ngayTra;

    private float giaPhong;

}
