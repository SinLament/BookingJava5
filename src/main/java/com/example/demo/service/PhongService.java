package com.example.demo.service;

import com.example.demo.entity.Phong;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface PhongService {
    @Transactional
    List<Phong> findAll();

    @Transactional
    List<Phong> findPhongByKhachsan(String khachSan);

    @Transactional
    List<Phong> sortPrice(Float priceLess);

    @Transactional
    Phong createOrUpdate(Phong phong);

    @Transactional
    void deletePhongByKhachSan_MaKhachSan(Integer maKhachSan);

    @Transactional
    List<Phong> findPhongByKhachSan_MaKhachSanAndTrangThai(Integer maKhachSan, String trangThai);

    @Transactional
    List<Phong> findBySoPhong(String soPhong);

    @Transactional
    Phong findById(Integer id);  // Thêm phương thức tìm theo ID
}
