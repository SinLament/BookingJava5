package com.example.demo.service.serviceImpl;

import com.example.demo.controller.entity.KhuyenMai;
import com.example.demo.controller.responsitory.KhuyenMaiRepo;
import com.example.demo.controller.service.KhuyenMaiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
  @Autowired
  KhuyenMaiRepo khuyenMaiRepo;

  @Override
  public List<KhuyenMai> findAllKhuyenMai() {
    return khuyenMaiRepo.findAll();
  }
  @Override
  public KhuyenMai savekhuyenMai(KhuyenMai khuyenMai) {
    return khuyenMaiRepo.save(khuyenMai);
  }

  @Override
  public void deleteKhuyenMaiByMaKhuyenMai(Integer maKhuyenMai) {
    khuyenMaiRepo.deleteKhuyenMaiByMaKhuyenMai(maKhuyenMai);
  }
}
