package com.example.demo.controller;

import com.example.demo.controller.dto.KhachHangDTO;
import com.example.demo.controller.entity.KhachHang;
import com.example.demo.controller.responsitory.KhachHangRepo;
import com.example.demo.controller.responsitory.KhachSanRepo;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {

  //Quốc
  @Autowired
  KhachHangRepo khachHangRepo;

  @Autowired
  KhachSanRepo khachSanRepo;

  @Autowired
  ServletContext app;
  @RequestMapping("/admin/khachhang")
  public String index() {
    return "/admin/user-list";
  }
  @GetMapping("/create")
  public String getCreate() {
    return "/admin/user-list";
  }
}
