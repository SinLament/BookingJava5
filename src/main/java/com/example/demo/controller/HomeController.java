package com.example.demo.controller;

import com.example.demo.responsitory.KhachSanRepo;
import com.example.demo.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @Autowired
  KhachSanRepo khachSanRepo;

  @Autowired
  SessionService session;

  @RequestMapping("/index")
  public String index() {
    return "home2";
  }
  @RequestMapping("/detail")
  public String shop_detail() {
    return "detail";
  }
  @GetMapping("/shop")
  public String shop() {
    return "hotel";
  }
  @GetMapping("/payment")
  public String getPayment(){return "pay";}
  @GetMapping("/homee")
  public String homee(Model model) {
      
      return "home2";
  }
}