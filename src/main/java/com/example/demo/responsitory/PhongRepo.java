package com.example.demo.responsitory;

import com.example.demo.entity.Phong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhongRepo extends JpaRepository<Phong, Integer> {

    @Query(value = "SELECT p.* FROM Phong p INNER JOIN Khach_san k ON p.Ma_khach_san = k.Ma_khach_san WHERE k.Ten_khach_san = ?1", nativeQuery = true)
    List<Phong> findPhongByKhachsan(String khachSan);

    @Query(value = "SELECT * FROM Phong p WHERE p.gia < ?1", nativeQuery = true)
    List<Phong> sortPrice(Float PriceLess);

    @Query(value = "SELECT p FROM Phong p WHERE p.soPhong = ?1")
    List<Phong> findBySoPhong(String soPhong);

    @Query(value = "DELETE FROM Phong p WHERE p.khachSan.maKhachSan = ?1", nativeQuery = true)
    void deletePhongByKhachSan_MaKhachSan(Integer maKhachSan);

    @Query(value = "SELECT p FROM Phong p WHERE p.trangThai = ?1 AND p.khachSan.maKhachSan = ?2")
    List<Phong> findPhongByTrangThaiAndKhachSan_MaKhachSan(String trangThai, Integer maKhachHang);
}
