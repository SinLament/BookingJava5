package com.example.demo.service.serviceImpl;

import com.example.demo.entity.KhachSan;
import com.example.demo.responsitory.KhachSanRepo;
import com.example.demo.service.KhachSanService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachSanServiceImpl implements KhachSanService {
  @Autowired
  KhachSanRepo khachSanRepo;

  @Override
  public List<KhachSan> findAllKhachSan() {
    return khachSanRepo.findAll();
  }
  @Override
  public KhachSan savekhachSan(KhachSan khachSan) {

    return khachSanRepo.save(khachSan);
  }
  @Override
  public List<KhachSan> findTop6ByXepHang() {
    return khachSanRepo.findTop6ByXepHang();
  }
  @Override
  public KhachSan getKhachSanById(int maKhachSan) {
    Optional<KhachSan> optionalProduct = khachSanRepo.findById(maKhachSan);
    return optionalProduct.orElse(null);
  }

  @Override
  public List<KhachSan> findThanhPhoAndSucChua(String thanhPho, int sucChua) {


    return khachSanRepo.findDistinctByThanhPhoAndListPhong_SucChuaGreaterThanEqual(thanhPho,sucChua);
  }

  @Override
  public KhachSan createOrUpdate(KhachSan khachSan) {
    return khachSanRepo.save(khachSan);
  }

  @Override
  public void deleteKhachSanByMaKhachSan(Integer makhachSan) {
    khachSanRepo.deleteKhachSanByMaKhachSan(makhachSan);
  }
}
