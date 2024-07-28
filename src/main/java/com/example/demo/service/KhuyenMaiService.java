package com.example.demo.service;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhuyenMaiService {
  private final KhuyenMaiRepo khuyenMaiRepo;

  public KhuyenMaiService(KhuyenMaiRepo khuyenMaiRepo) {
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
