package com.example.demo.service;


import com.example.demo.entity.KhachHang;

import java.util.List;

public interface AdminService {
  List<KhachHang> findAllKhachHang();
  KhachHang addKhachHang(KhachHang khachHang);
  void deleteKhachHang(Integer khachHangId);
  KhachHang findKhachHangById(Integer maKhachHang);
}
