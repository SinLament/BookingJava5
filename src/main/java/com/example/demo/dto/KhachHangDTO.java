package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangDTO {

    private Integer maKhachHang;
    @NotBlank(message = "Không được để trống tên đang nhập")
    private String username;
    @NotBlank(message = "Không được để trống mật khẩu")
    private String password;
    @NotBlank(message = "không được để trống họ và tên")
    private String fullname;

    private boolean gender;

    private Date birthday;

    private String address;
    @NotBlank(message = "Không được để trống email")
    @Email(message = "Email không đúng định dạng")
    private String email;

    private String sdt;
}
