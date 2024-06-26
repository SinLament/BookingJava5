package com.example.demo.service;


import com.example.demo.controller.entity.KhuyenMai;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KhuyenMaiService {
  @Transactional
  List<KhuyenMai> findAllKhuyenMai();
  @Transactional
  KhuyenMai savekhuyenMai(KhuyenMai khuyenMai);
  @Transactional
  void deleteKhuyenMaiByMaKhuyenMai(Integer maKhuyenMai);

}
