package com.example.demo.service;


import com.example.demo.entity.DichVu;

import java.util.List;

public interface DichVuService {
    List<DichVu> getAllDichVu();
    DichVu getDichVuById(Long id);
    DichVu saveDichVu(DichVu dichVu);
}
