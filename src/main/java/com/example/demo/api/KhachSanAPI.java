package com.example.demo.api;
import com.example.demo.entity.KhachSan;
import com.example.demo.service.KhachSanService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
      result.put("success", true);
      result.put("message", "Call api succes");
      result.put("data", khachSanService.savekhachSan(KhachSan));
    } catch (Exception e) {
      result.put("success", false);
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


}
