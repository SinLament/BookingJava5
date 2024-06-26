package com.example.demo.responsitory;


import java.util.List;

import com.example.demo.entity.KhachSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachSanRepo extends JpaRepository<KhachSan, Integer> {
  @Query("SELECT ks FROM KhachSan ks ORDER BY ks.xepHang DESC LIMIT 6")
  List<KhachSan> findTop6ByXepHang();
  List<KhachSan> findDistinctByThanhPhoAndListPhong_SucChuaGreaterThanEqual(String thanhPho, int sucChua);
  KhachSan save(KhachSan khachSan);
  void deleteKhachSanByMaKhachSan(Integer makhachSan);
}
