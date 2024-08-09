package com.example.demo.responsitory;

import com.example.demo.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhuyenMaiRepo extends JpaRepository<KhuyenMai, Integer> {
    // Các phương thức tiêu chuẩn của JpaRepository sẽ được sử dụng
}
