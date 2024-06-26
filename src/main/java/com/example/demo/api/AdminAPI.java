package com.example.demo.api;

import com.example.demo.service.AdminService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin-khachhang")
public class AdminAPI {
  @Autowired
  private AdminService adminService;
  @GetMapping("/getAllkhachHang")
  public ResponseEntity<?> getAllKhachHang(){
    Map<String, Object> rs = new HashMap();
    try {

      rs.put("status", true);
      rs.put("message", "Call api success");
      rs.put("data",adminService.findAllKhachHang());
    } catch (Exception ex) {
      rs.put("status", false);
      rs.put("message", "Call api failed");
      rs.put("data", null);
    }
    return ResponseEntity.ok(rs);
  }
  @DeleteMapping("/deleteKhachHang/{id}")
  public ResponseEntity<?> deleteKhachHang(@PathVariable("id") Integer khachHangId) {
    Map<String, Object> rs = new HashMap<>();
    try {
      adminService.deleteKhachHang(khachHangId);
      rs.put("status", true);
      rs.put("message", "Khách hàng đã được xóa thành công");
    } catch (Exception ex) {
      rs.put("status", false);
      rs.put("message", "Xóa khách hàng thất bại");
    }
    return ResponseEntity.ok(rs);
  }
  @GetMapping("/editKhachHangById")
  public ResponseEntity<?> editKhachHangById(@RequestParam("maKhachHang") Integer maKhachHang) {
    Map<String, Object> result = new HashMap<>();
    try {
      result.put("success", true);
      result.put("message", "Call api succes");
      result.put("data", adminService.findKhachHangById(maKhachHang));
    } catch (Exception e) {
      result.put("success", false);
      result.put("message", "Call api fail");
      result.put("data", null);
    }
    return ResponseEntity.ok(result);
  }
}
