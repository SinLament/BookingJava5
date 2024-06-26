package com.example.demo.service.serviceImpl;

import com.example.demo.controller.entity.DanhGia;
import com.example.demo.controller.Responsitori.DanhGiaRespository;
import com.example.demo.controller.service.DanhGiaService;
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
