package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_khach_hang")
    private Integer maKhachHang;

    @Column(name = "Ten_tai_khoan", unique = true)
    private String username;

    @Column(name = "Mat_khau")
    private String password;

    @Column(name="Ho_ten")
    private String fullname;

    @Column(name = "Gioi_tinh")
    private boolean gender;

    @Column(name = "Ngay_sinh")
    private Date birthday;

    @Column(name = "Dia_chi")
    private String address;

    @Column(name = "Email" , unique = true)
    private String email;

    @Column(name = "SDT", unique = true)
    private String sdt;

}
