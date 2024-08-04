package com.example.demo.service.serviceImpl;

import com.example.demo.entity.KhachHang;
import com.example.demo.responsitory.KhachHangRepo;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
    public class KhachHangServiceImp implements KhachHangService {

    @Autowired
    private KhachHangRepo repo;

    @Override
    public List<KhachHang> findAllKhachHang() {
        return repo.findAll();
    }

    @Override
    public KhachHang findKhachHangByUsername(String username) {
        return repo.findKhachHangByUsername(username);
    }

    @Override
    public KhachHang addKhachHang(KhachHang khachHang) {
        return repo.save(khachHang);
    }

    @Override
    public void deleteKhachHangById(Integer id) {
        repo.deleteKhachHangByMaKhachHang(id);
    }

    @Override
    public KhachHang findKhachHangById(Integer maKH) {
        return null;
    }

    @Override
    public KhachHang updateKhachHang(KhachHang kh) {
        return repo.save(kh);
    }


}
