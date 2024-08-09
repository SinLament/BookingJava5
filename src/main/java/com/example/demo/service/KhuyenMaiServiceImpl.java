package com.example.demo.service;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.responsitory.KhuyenMaiRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class KhuyenMaiServicelmpl {
  private final KhuyenMaiRepo khuyenMaiRepo;

  public KhuyenMaiServicelmpl(KhuyenMaiRepo khuyenMaiRepo) {
    this.khuyenMaiRepo = khuyenMaiRepo;
  }

  public List<KhuyenMai> findAllKhuyenMai() {
    return khuyenMaiRepo.findAll();
  }

  public KhuyenMai savekhuyenMai(KhuyenMai khuyenMai) {
    return khuyenMaiRepo.save(khuyenMai);
  }

  public void deleteKhuyenMaiByMaKhuyenMai(Integer maKhuyenMai) {
    khuyenMaiRepo.deleteById(maKhuyenMai);
  }

  public KhuyenMai findById(Integer maKhuyenMai) {
    Optional<KhuyenMai> optionalKhuyenMai = khuyenMaiRepo.findById(maKhuyenMai);
    return optionalKhuyenMai.orElse(null);
  }

  public KhuyenMai updateKhuyenMai(KhuyenMai khuyenMai) {
    return khuyenMaiRepo.save(khuyenMai);
  }
}
