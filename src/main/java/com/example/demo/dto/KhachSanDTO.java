package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachSanDTO {

    private Integer maKhachSan;
    @NotBlank(message = "Tên khách sạn không được để trống")
    private String tenKhachSan;
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;
    @NotBlank(message = "Thành phố không được để trống")
    private String thanhPho;

    private String moTa;

    private BigDecimal xepHang;

    @NotBlank(message = "Hình không được để trống")
    private String hinh;
}
