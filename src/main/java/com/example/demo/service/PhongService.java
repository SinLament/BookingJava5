package com.example.demo.service;


import com.example.demo.controller.entity.Phong;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface PhongService {
    @Transactional
    List<Phong> findAll();
    @Transactional
    List<Phong> findPhongByKhachsan(String KhachSan);
    @Transactional
    List<Phong> sortPrice(Float PriceLess);
    @Transactional
    Phong createOrUpdate(Phong phong);
    @Transactional
    void deletePhongByKhachSan_MaKhachSan(Integer maKhachSan);

    List<Phong> findPhongByKhachSan_MaKhachSanAndTrangThai(Integer maKhachSan, Boolean trangThai);
}
