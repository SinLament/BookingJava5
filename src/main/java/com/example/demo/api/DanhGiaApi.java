package com.example.demo.api;


import com.example.demo.controller.entity.DanhGia;
import com.example.demo.controller.service.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/rate")
@RestController
public class DanhGiaApi {
    @Autowired
    private DanhGiaService danhGiaService;
    @GetMapping("/danhgia")
    public ResponseEntity <?> danhGia(@RequestBody DanhGia danhGia) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("Success", true);
            result.put("Message","Call success");
            result.put("data", danhGiaService.getAllDanhGia());
        }catch (Exception e){
            result.put("Success", false);
            result.put("Message","Call fail");
            result.put("data", null);
        }
return ResponseEntity.ok(result);
    }
}

