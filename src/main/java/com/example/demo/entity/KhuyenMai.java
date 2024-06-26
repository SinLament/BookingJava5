package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Khuyen_mai")
public class KhuyenMai implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Ma_khuyen_mai")
  private Integer maKhuyenMai;

  @Column(name = "Ten_khuyen_mai")
  private String tenKhuyenMai;

  @Column(name = "Mo_ta")
  private String moTa;

  @Column(name = "Ngay_bat_dau")
  @Temporal(TemporalType.DATE)
  private Date ngayBatDau = new Date();

  @Column(name = "Ngay_ket_thuc")
  @Temporal(TemporalType.DATE)
  private Date ngayKetThuc = new Date();

  @DecimalMin(value = "0.00", inclusive = true)
  @DecimalMax(value = "100.00", inclusive = true)
  @Column(name = "Muc_giam")
  private BigDecimal mucGiam;
}
