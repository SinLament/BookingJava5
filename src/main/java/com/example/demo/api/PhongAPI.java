package com.example.demo.api;


import com.example.demo.entity.Phong;
import com.example.demo.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api-phong")
@RestController
public class PhongAPI {
    @Autowired
    private PhongService phongService;

    @GetMapping("/get-all")
    public ResponseEntity<?> doGetAllPhong() {
        Map<String, Object> rs = new HashMap();
        try {
            List<Phong> phongList = phongService.findAll();

            rs.put("status", true);
            rs.put("message", "Call api success");
            rs.put("data",phongList);
        } catch (Exception ex) {
            rs.put("status", false);
            rs.put("message", "Call api failed");
            rs.put("data", null);
        }
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/find-by-KhachSan")
    public ResponseEntity<?> doFindByName(@RequestParam("khachSan") String KhachSan) {
        Map<String, Object> rs = new HashMap();

        try {
            rs.put("status", true);
            rs.put("message", "Call api success");
            rs.put("data", phongService.findPhongByKhachsan(KhachSan));
        } catch (Exception ex) {
            rs.put("status", false);
            rs.put("message", "Call api failed");
            rs.put("data", null);
        }
        return ResponseEntity.ok(rs);
    }
    @GetMapping("/sortPrice")
    public ResponseEntity<?> doGetPriceLess(@RequestParam("Price") Float Price) {
        Map<String, Object> rs = new HashMap();
        try {
            rs.put("status", true);
            rs.put("message", "Call api success");
            rs.put("data", phongService.sortPrice(Price));
        } catch (Exception ex) {
            rs.put("status", false);
            rs.put("message", "Call api failed");
            rs.put("data", null);
        }
        return ResponseEntity.ok(rs);
    }
    @PostMapping("/save-phong")
    public ResponseEntity<?> savePhong(@RequestBody Phong phong){
        Map<String,Object> result = new HashMap<>();

        try {
            result.put("status", true);
            result.put("message", "Call api success");
            result.put("data", phongService.createOrUpdate(phong));
        }catch (Exception e){
            result.put("status", false);
            result.put("message", "Call api failed");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/find-phong-by-ma-khach-san")
    public ResponseEntity<?> findPhongByMaKhachSan(@RequestParam("maKhachSan") Integer maKhachSan, Boolean trangThai){
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message","Call api success");
            result.put("data",phongService.findPhongByKhachSan_MaKhachSanAndTrangThai(maKhachSan,trangThai));
        }catch (Exception e){
            result.put("status", true);
            result.put("message","Call api success");
            result.put("data",null);
        }
        return ResponseEntity.ok(result);
    }
}
