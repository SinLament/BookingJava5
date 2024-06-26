package com.example.demo.api;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api-khachhang")
public class KhachHangAPI {
    @Autowired
    private KhachHangService service;

    @GetMapping("/get-all-khachHang")
    public ResponseEntity<?> getAllKhachHang(){
        Map<String, Object> rs = new HashMap();
        try {

            rs.put("status", true);
            rs.put("message", "Call api success");
            rs.put("data",service.findAllKhachHang());
        } catch (Exception ex) {
            rs.put("status", false);
            rs.put("message", "Call api failed");
            rs.put("data", null);
            ex.printStackTrace();
        }
        return ResponseEntity.ok(rs);
    }
    @GetMapping("/get-khachHang-by-username")
    public ResponseEntity<?> getKhachHangByUsername(@RequestParam("username") String username){
        Map<String, Object> rs = new HashMap();
        try {
            rs.put("status", true);
            rs.put("message", "Call api success");
            rs.put("data",service.findKhachHangByUsername(username));
        } catch (Exception ex) {
            rs.put("status", false);
            rs.put("message", "Call api failed");
            rs.put("data", null);
            ex.printStackTrace();
        }
        return ResponseEntity.ok(rs);
    }
    @PostMapping("/save-khacHhang")
    public ResponseEntity<?> saveKhachHang(@RequestBody KhachHang khachHang){
        Map<String,Object> rs = new HashMap<>();
        try {
            rs.put("status", true);
            rs.put("message", "Call api success");
            rs.put("data",service.addKhachHang( khachHang));

        }catch (Exception ex){
            rs.put("status", false);
            rs.put("message", "Call api failed");
            rs.put("data", null);
            ex.printStackTrace();
        }
        return ResponseEntity.ok(rs);
    }
    @DeleteMapping("/delete-khachHang-by-makh")
    public ResponseEntity<?> deleteKhachHangByMaKH(@RequestParam("maKH") Integer maKH){
        Map<String,Object> rs = new HashMap<>();
        try {
            service.deleteKhachHangById(maKH);
            rs.put("status", true);
            rs.put("message", "Delete success");

        }catch (Exception ex){
            rs.put("status", false);
            rs.put("message", "Delete failed");
            ex.printStackTrace();
        }
        return ResponseEntity.ok(rs);

    }
}
