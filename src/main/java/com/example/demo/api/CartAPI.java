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
}
