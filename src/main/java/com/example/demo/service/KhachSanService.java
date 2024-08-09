package com.example.demo.service;


import com.example.demo.entity.KhachSan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KhachSanService {
  @Transactional
  List<KhachSan> findAllKhachSan();
  @Transactional
  KhachSan savekhachSan(KhachSan khachSan);
  @Transactional
  List<KhachSan> findTop6ByXepHang();
  @Transactional
  KhachSan getKhachSanById(int maKhachSan);
  @Transactional
  List<KhachSan> findThanhPho(String thanhPho);
  @Transactional
  KhachSan createOrUpdate(KhachSan khachSan);
  @Transactional
  void deleteKhachSanByMaKhachSan(Integer makhachSan);

    void deletekhachSan(Integer khachSanId);

  KhachSan updateKhachHang(KhachSan khachSan);
}
