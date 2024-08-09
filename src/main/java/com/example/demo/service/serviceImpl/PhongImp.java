package com.example.demo.service.serviceImpl;

import com.example.demo.entity.Phong;

import com.example.demo.responsitory.PhongRepo;
import com.example.demo.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongImp implements PhongService {
    @Autowired
    private PhongRepo repo;

    @Override
    public List<Phong> findPhongByKhachsan(String khachSan) {
        return repo.findPhongByKhachsan(khachSan);
    }

    @Override
    public List<Phong> sortPrice(Float priceLess) {
        return repo.sortPrice(priceLess);
    }

    @Override
    public List<Phong> findAll() {
        return repo.findAll();
    }

    @Override
    public Phong createOrUpdate(Phong phong) {
        return repo.save(phong);
    }

    @Override
    public void deletePhongByKhachSan_MaKhachSan(Integer maKhachSan) {
        repo.deletePhongByKhachSan_MaKhachSan(maKhachSan);
    }

    @Override
    public List<Phong> findPhongByKhachSan_MaKhachSanAndTrangThai(Integer maKhachSan, String trangThai) {
        return repo.findPhongByTrangThaiAndKhachSan_MaKhachSan(trangThai, maKhachSan);
    }

    @Override
    public List<Phong> findBySoPhong(String soPhong) {
        return repo.findBySoPhong(soPhong);
    }

    @Override
    public Phong findById(Integer id) {
        return repo.findById(id).orElse(null);  // Thay đổi để gọi phương thức tìm phòng theo ID
    }
}
