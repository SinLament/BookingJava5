package com.example.demo.controller;

import com.example.demo.api.KhachHangAPI;
import com.example.demo.api.KhachSanAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @GetMapping("/list")
    public String listHotel(){

        return "hotel";
    }
    @GetMapping("/detail/*")
    public String detailHotel(){
        return "detail";
    }
}
