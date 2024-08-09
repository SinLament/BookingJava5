package com.example.demo.api;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.KhachSan;
import com.example.demo.service.KhachSanService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/khachsan-api")

public class KhachSanAPI {
  @Autowired
  private  KhachSanService khachSanService;

  @GetMapping("/getAllKhachSan")
  public ResponseEntity<?> doGetAllKhachSan(){
    Map<String, Object> rs = new HashMap();
    try {

      rs.put("status", true);
      rs.put("message", "Call api success");
      rs.put("data",khachSanService.findAllKhachSan());
    } catch (Exception ex) {
      rs.put("status", false);
      rs.put("message", "Call api failed");
      rs.put("data", null);
    }
    return ResponseEntity.ok(rs);
  }
  @PostMapping("saveKhachSan")
  public ResponseEntity<?> saveKhachSan(@RequestBody KhachSan KhachSan) {
    Map<String, Object> result = new HashMap();
    try {
      result.put("status", true);
      result.put("message", "Call api succes");
      result.put("data", khachSanService.savekhachSan(KhachSan));
    } catch (Exception e) {
      result.put("status", false);
      result.put("message", "Call api fail");
      result.put("data", null);
    }
    return ResponseEntity.ok(result);
  }
  @GetMapping("findTop6ByXepHang")
  public ResponseEntity<?> findTop6ByXepHang() {
    Map<String, Object> result = new HashMap();
    try {
      result.put("success", true);
      result.put("message", "Call api succes");
      result.put("data", khachSanService.findTop6ByXepHang());
    } catch (Exception e) {
      result.put("success", false);
      result.put("message", "Call api fail");
      result.put("data", null);
    }
    return ResponseEntity.ok(result);
  }
  @GetMapping("/find-khach-san-by-ma-khach-san")
  public ResponseEntity<?> findKhachSanById(@RequestParam("maKhachSan") int maKhachSan) {
    Map<String, Object> result = new HashMap<>();
    try {
      result.put("success", true);
      result.put("message", "Call api succes");
      result.put("data", khachSanService.getKhachSanById(maKhachSan));
    } catch (Exception e) {
      result.put("success", false);
      result.put("message", "Call api fail");
      result.put("data", null);
    }
    return ResponseEntity.ok(result);
  }
  @GetMapping("/find-by-thanh-pho-and-suc-chua")
  public ResponseEntity<?> findByThanhPhoAndSucChua(@RequestParam("thanhPho") String thanhPho,
                                                    @RequestParam("sucChua") Integer sucChua){
    Map<String,Object> result = new HashMap<>();
    try {
      List<KhachSan> khachSans = khachSanService.findThanhPho(thanhPho);
      if (khachSans.isEmpty()){
        result.put("status", true);
        result.put("message","Không tìm thấy khách sạn");
        result.put("data", null);
      }else {
        result.put("status", true);
        result.put("message","Đã tìm thấy khách sạn");
        result.put("data", khachSans);
      }
    }catch (Exception e){
      result.put("status", true);
      result.put("message","Lỗi tìm kiếm khách sạn "+e);
      result.put("data", null);
      e.printStackTrace();
    }
    return ResponseEntity.ok(result);
  }
  @DeleteMapping("/delete-khachSan-by-maks")
  public ResponseEntity<?> deleteKhachSan(@RequestParam("maKS") Integer maKS) {
    Map<String, Object> rs = new HashMap<>();
    try {
      khachSanService.deletekhachSan(maKS);
      rs.put("status", true);
      rs.put("message", "Khách Sạn đã được xóa thành công");
    } catch (Exception ex) {
      rs.put("status", false);
      rs.put("message", "Xóa Sạn hàng thất bại");
    }
    return ResponseEntity.ok(rs);
  }

  @PutMapping("/update-khachSan/{maKS}")
  public ResponseEntity<?> updateKhachHang(@PathVariable Integer maKS, @RequestBody KhachSan KhachSan) {
    Map<String, Object> rs = new HashMap<>();
    try {
      rs.put("status", true);
      rs.put("message", "Cập nhật khách hàng thành công");
      rs.put("data", khachSanService.updateKhachHang(KhachSan));
    } catch (Exception ex) {
      rs.put("status", false);
      rs.put("message", "Cập nhật khách hàng thất bại");
      rs.put("data", null);
      ex.printStackTrace();
    }
    return ResponseEntity.ok(rs);
  }

}
