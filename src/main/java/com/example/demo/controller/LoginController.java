package com.example.demo.controller;

import com.example.demo.controller.entity.KhachHang;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.controller.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.controller.responsitory.KhachHangRepo;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class LoginController {
    //Thư
    @Autowired
    KhachHangRepo khachHangRepo;

    @Autowired
    SessionService session;

    @GetMapping("/sign-in")
    public String signin() {
        return "account/DangNhap";
    }

    @GetMapping("/sign-up")
    public String signup() {
        return "account/DangKy";
    }

}