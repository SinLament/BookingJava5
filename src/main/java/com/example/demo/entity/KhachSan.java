package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Khach_san")
public class KhachSan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Ma_khach_san")
  private Integer maKhachSan;

  @Column(name = "Ten_khach_san")
  private String tenKhachSan;

  @Column(name = "Dia_chi")
  private String diaChi;

  @Column(name = "Thanh_pho")
  private String thanhPho;

  @Column(name = "Mo_ta")
  private String moTa;

  @Column(name = "Xep_hang")
  private BigDecimal xepHang;

  @Column(name = "Hinh")
  private String hinh;

  @OneToMany(mappedBy = "khachSan", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Phong> listPhong;

  @OneToMany(mappedBy = "khachSan", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<DichVu> listDichVu;

}
