package com.example.demo.controller.Controller;

import com.example.demo.controller.Utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.demo.controller.Responsitory.KhachHangRepo;
import com.example.demo.controller.Responsitory.KhachSanRepo;
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
  public String cart(Model model) {

    return "cart";
  }

  @GetMapping("/cart/add")
  public String cart_add(Model model, @RequestParam("id") Integer id) {
    return "shopping-cart";
  }

  @GetMapping("/cart/update")
  public String cart_update(Model model, @RequestParam("id") Integer id, @RequestParam("qty") Integer qty) {

    return "shopping-cart";
  }

  @GetMapping("/cart/delete")
  public String cart_delete(Model model, @RequestParam("id") Integer id) {
    return "shopping-cart";
  }

  @PostMapping("/order")
  public String shopping_order(Model model, @RequestParam("address") String address) {

    return "shopping-cart";
  }
}
