package com.example.demo.controller;

import com.example.demo.responsitory.KhachHangRepo;
import com.example.demo.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
  //hoang bao
  @Autowired
  KhachHangRepo khachHangRepo;

  @Autowired
  SessionService session;
  //Getforgot
  @GetMapping("/forgot-password")
  public String forgotPassword() {
    return "";
  }

  @PostMapping("/forgot-password")
  public String forgotPassword_find(Model model, @RequestParam("username") String username) {
    return "";
  }

  //gửi otp ve mail-Getreset
  @GetMapping("/reset-password/{username}/{otp}")
  public String resetPassword(Model model, @PathVariable("username") String username,
      @PathVariable("otp") Integer otp) {
    return "";
  }
  //Postreset
  @PostMapping("/reset-password/{username}")
  public String resetPassword_reset(Model model, @PathVariable("username") String username,
      @RequestParam("password") String password, @RequestParam("confirm") String confirm) {

    return "";
  }
//logout
  @GetMapping("/account/logout")
  public String logout() {
    return "";
  }
  //change
  @PostMapping("/account/change-password")
  public String change_password(Model model, @RequestParam("oldPass") String oldPass,
      @RequestParam("newPass") String newPass, @RequestParam("confirm-newPass") String confirm) {
    return "";
  }
}
