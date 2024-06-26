package com.example.demo.api;

import com.example.demo.controller.entity.KhuyenMai;
import com.example.demo.controller.service.KhuyenMaiService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/khuyenmai-api")
@RestController
@RequiredArgsConstructor
public class KhuyenMaiAPI {
  private final KhuyenMaiService khuyenMaiService;

  @GetMapping("/getAllKhuyenMai")
  public ResponseEntity<?> doGetAllKhuyenMai() {
    Map<String, Object> result = new HashMap();
    try {
      result.put("success", true);
      result.put("message", "Call api succes");
      result.put("data", khuyenMaiService.findAllKhuyenMai());
    } catch (Exception e) {
      result.put("success", false);
      result.put("message", "Call api fail");
      result.put("data", null);
    }
    return ResponseEntity.ok(result);
  }
  @PostMapping("/saveKhuyenMai")
  public ResponseEntity<?> saveKhuyenMai(@RequestBody KhuyenMai khuyenMai) {
    Map<String, Object> result = new HashMap();
    try {
      result.put("success", true);
      result.put("message", "Call api succes");
      result.put("data", khuyenMaiService.savekhuyenMai(khuyenMai));
    } catch (Exception e) {
      result.put("success", false);
      result.put("message", "Call api fail");
      result.put("data", null);
    }
    return ResponseEntity.ok(result);
  }
  @DeleteMapping("/delete-khuyen-mai")
  public ResponseEntity<?> deleteKhuyenMai(@RequestParam("maKhuyenMai") Integer maKhuyenMai){
    Map<String,Object> result = new HashMap<>();
    try {
      khuyenMaiService.deleteKhuyenMaiByMaKhuyenMai(maKhuyenMai);
      result.put("success", true);
      result.put("message", "Xóa thành công");
    }catch (Exception e){
      result.put("success", false);
      result.put("message", "Xóa thất bại");

    }
    return ResponseEntity.ok(result);
  }

}
