package com.example.demo.responsitory;


import com.example.demo.controller.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhuyenMaiRepo extends JpaRepository<KhuyenMai, Integer> {
    @Override
    List<KhuyenMai> findAll();
    KhuyenMai save(KhuyenMai khuyenMai);
    void deleteKhuyenMaiByMaKhuyenMai(Integer maKhuyenMai);
}
