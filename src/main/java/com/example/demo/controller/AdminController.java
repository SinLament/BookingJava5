package com.example.demo.controller;

import com.example.demo.dto.KhachHangDTO;
import com.example.demo.entity.KhachHang;
import com.example.demo.responsitory.KhachHangRepo;
import com.example.demo.responsitory.KhachSanRepo;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {


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
  @RequestMapping("/admin/product")
  public String index2() {
    return "/admin/product-list";
  }

}
