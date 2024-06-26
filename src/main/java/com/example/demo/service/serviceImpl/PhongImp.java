package com.example.demo.service.serviceImpl;

import com.example.demo.controller.entity.Phong;
import com.example.demo.controller.responsitory.PhongRepo;
import com.example.demo.controller.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongImp implements PhongService {
    @Autowired
    PhongRepo repo;

    @Override
    public List<Phong> findPhongByKhachsan(String KhachSan) {
        return repo.findPhongByKhachsan(KhachSan);
    }

    public List<Phong> sortPrice(Float PriceLess)  { return repo.sortPrice(PriceLess);}

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
    public List<Phong> findPhongByKhachSan_MaKhachSanAndTrangThai(Integer maKhachSan, Boolean trangThai) {
        return repo.findPhongByTrangThaiAndAndKhachSan_MaKhachSan(trangThai,maKhachSan);
    }
}


