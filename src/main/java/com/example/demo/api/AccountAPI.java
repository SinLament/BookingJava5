package com.example.demo.api;


import java.util.HashMap;
import java.util.Map;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountAPI {

  @Autowired
  private AccountService accountService;

  @PostMapping("/sign-up")
  public ResponseEntity<?> Register(@RequestBody Account account) {
    Map<String, Object> response = new HashMap<>();
    try {
      response.put("status", true);
      response.put("message", "Đăng ký thành công");
      response.put("data", accountService.Register(account));
    } catch (Exception ex) {
      response.put("status", false);
      response.put("message", "Đăng ký thất bại");
      response.put("data", null);
    }
    return ResponseEntity.ok(response);
  }
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Account account) {
    Map<String, Object> response = new HashMap<>();
    try {
      UserDetails loggedInAccount = accountService.Login(account.getUsername(), account.getPassword());
      if (loggedInAccount != null) {
        response.put("status", true);
        response.put("message", "Đăng nhập thành công");
        response.put("data", loggedInAccount);
      } else {
        response.put("status", false);
        response.put("message", "Tên đăng nhập hoặc mật khẩu không đúng");
        response.put("data", null);
      }
    } catch (Exception ex) {
      response.put("status", false);
      response.put("message", "Đăng nhập thất bại");
      response.put("data", null);
    }
    return ResponseEntity.ok(response);
  }

}