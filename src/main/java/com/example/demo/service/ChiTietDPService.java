package com.example.demo.service;

import com.example.demo.entity.ChiTietDatPhong;


import java.util.List;

public interface ChiTietDPService {
    public List<ChiTietDatPhong> getAllChiTietDatPhong();
    ChiTietDatPhong saveChiTietDatPhong(ChiTietDatPhong chiTietDatPhong);
    public void deleteChiTietDatPhong(Integer id);
}
