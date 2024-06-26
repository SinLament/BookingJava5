package com.example.demo.service;


import com.example.demo.entity.KhachHang;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface KhachHangService {
    @Transactional(readOnly = true)
    List<KhachHang>  findAllKhachHang();
    @Transactional
    KhachHang findKhachHangByUsername(String username);
    @Transactional
    KhachHang addKhachHang(KhachHang khachHang);
    @Transactional
    void deleteKhachHangById(Integer id);


}
