package com.example.demo.api;

import com.example.demo.controller.entity.DichVu;
import com.example.demo.controller.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/dich-vu-api")
@RestController
public class DichVuApi {

    @Autowired
    private DichVuService dichVuService;

    @GetMapping("/getAllDichVu")
    public ResponseEntity<Map<String, Object>> getAllDichVu() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<DichVu> dichVuList = dichVuService.getAllDichVu();
            result.put("Success", true);
            result.put("Message", "Call API success");
            result.put("Data", dichVuList);
        } catch (Exception e) {
            result.put("Success", false);
            result.put("Message", "Call API fail");
            result.put("Data", null);
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/postDichVu")
    public ResponseEntity<Map<String, Object>> postDichVu(@RequestBody DichVu dichVu) {
        Map<String, Object> result = new HashMap<>();
        try {
            DichVu savedDichVu = dichVuService.saveDichVu(dichVu);
            result.put("Success", true);
            result.put("Message", "Call API success");
            result.put("Data", savedDichVu);
        } catch (Exception e) {
            result.put("Success", false);
            result.put("Message", "Call API fail");
            result.put("Data", null);
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }
}
