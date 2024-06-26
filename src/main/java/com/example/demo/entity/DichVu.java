package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Dich_vu")
@Getter
@Setter
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu")
    private Long maDichVu;
    @ManyToOne
    @JoinColumn(name = "ma_khach_san")
    @JsonBackReference
    private KhachSan khachSan;

    @Column(name = "ten_dich_vu")
    private String tenDichVu;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "gia")
    private Double gia;
}
