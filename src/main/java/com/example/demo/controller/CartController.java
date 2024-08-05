package com.example.demo.controller.Controller;


import com.example.demo.responsitory.KhachHangRepo;
import com.example.demo.responsitory.KhachSanRepo;
import com.example.demo.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CartController {
  // gia bảo
  @Autowired
  KhachHangRepo khachHangRepo;

  @Autowired
  KhachSanRepo khachSanRepo;

  @Autowired
  SessionService session;
  // tt cart theo tk username
  @GetMapping("/cart")
  public String cart() {
    return "cart";
  }
}
