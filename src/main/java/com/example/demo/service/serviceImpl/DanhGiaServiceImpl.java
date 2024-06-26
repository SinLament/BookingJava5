package com.example.demo.service.serviceImpl;


import com.example.demo.entity.DanhGia;
import com.example.demo.responsitory.DanhGiaRespository;
import com.example.demo.service.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhGiaServiceImpl implements DanhGiaService {
    @Autowired
    private DanhGiaRespository danhgiaRespository;
    @Override
    public List<DanhGia> getAllDanhGia() {

        return danhgiaRespository.findAll();
    }
}
