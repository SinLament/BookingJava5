package com.example.demo.api;



import com.example.demo.entity.ChiTietDatPhong;
import com.example.demo.entity.DatPhong;
import com.example.demo.service.ChiTietDPService;
import com.example.demo.service.DatPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/cart")
@RestController
public class CartAPI {

    @Autowired
    private ChiTietDPService chiTietRepo;

    @Autowired
    private DatPhongService Repo;


    @GetMapping("/DatPhong/get-all")
    public ResponseEntity<?> getAllDatPhong() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<DatPhong> datPhongList = Repo.getAllDatPhong();
            response.put("status", true);
            response.put("message", "Call API success");
            response.put("data", datPhongList);
        } catch (Exception ex) {
            response.put("status", false);
            response.put("message", "Call API failed");
            response.put("data", null);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/DatPhong/create")
    public ResponseEntity<?> createDatPhong(@RequestBody DatPhong datPhong) {
        System.out.println("Received DatPhong: " + datPhong);
        Map<String, Object> response = new HashMap<>();
        try {
            DatPhong savedDatPhong = Repo.saveDatPhong(datPhong);
            response.put("status", true);
            response.put("message", "Create API success");
            response.put("data", savedDatPhong);
        } catch (Exception ex) {
            response.put("status", false);
            response.put("message", "Create API failed");
            response.put("data", datPhong);
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/DatPhong/delete/{id}")
    public ResponseEntity<?> deleteDatPhong(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("status", true);
            response.put("message", "Delete API success");
            Repo.deleteDatPhong(id);
        } catch (Exception ex) {
            response.put("status", false);
            response.put("message", "Delete API failed");
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/DatPhong/update/{id}")
    public ResponseEntity<?> updateDatPhong(@RequestBody DatPhong DatPhong) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("success", true);
            result.put("message", "Call api success");
            result.put("data", Repo.updateDatPhong(DatPhong));
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Call api fail");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/ChiTietDatPhong/get-all")
    public ResponseEntity<?> getAllChiTietDatPhong() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<ChiTietDatPhong> datPhongList = chiTietRepo.getAllChiTietDatPhong();
            response.put("status", true);
            response.put("message", "Call API success");
            response.put("data", datPhongList);
        } catch (Exception ex) {
            response.put("status", false);
            response.put("message", "Call API failed");
            response.put("data", null);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/ChiTietDatPhong/create")
    public ResponseEntity<?> createChiTietDatPhong(@RequestBody ChiTietDatPhong chiTietDatPhong) {
        Map<String, Object> response = new HashMap<>();
        try {

            ChiTietDatPhong savedChiTietDatPhong = chiTietRepo.saveChiTietDatPhong(chiTietDatPhong);

            response.put("status", true);
            response.put("message", "Create API success");
            response.put("data", savedChiTietDatPhong);
        } catch (Exception ex) {
            response.put("status", false);
            response.put("message", "Create API failed");
            response.put("data", null);
        }
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/ChiTietDatPhong/delete/{id}")
    public ResponseEntity<?> deleteChiTietDatPhong(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("status", true);
            response.put("message", "Delete API success");
            chiTietRepo.deleteChiTietDatPhong(id);
        } catch (Exception ex) {
            response.put("status", false);
            response.put("message", "Delete API failed");
        }
        return ResponseEntity.ok(response);
    }
    @PutMapping("/ChiTietDatPhong/update/{id}")
    public ResponseEntity<?> updateChiTietDatPhong(@RequestBody ChiTietDatPhong ChiTietDatPhong) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("success", true);
            result.put("message", "Call api success");
            result.put("data", chiTietRepo.updateChiTietDatPhong(ChiTietDatPhong));
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Call api fail");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }


@PutMapping("/update-TrangThai/{maKH}")
public ResponseEntity<?> updateTrangThai(@PathVariable Integer maDP, @RequestParam String TrangThai) {
    Map<String, Object> rs = new HashMap<>();
    try {
        DatPhong Taget = Repo.getDatPhongId(maDP);
        Taget.setTrangThai(TrangThai);
        rs.put("status", true);
        rs.put("message", "Cập nhật khách hàng thành công");
        rs.put("data", Repo.updateDatPhong(Taget));
    } catch (Exception ex) {
        rs.put("status", false);
        rs.put("message", "Cập nhật khách hàng thất bại");
        rs.put("data", null);
        ex.printStackTrace();
    }
    return ResponseEntity.ok(rs);
}
}
