package com.example.demo.service.serviceImpl;


import com.example.demo.entity.ChiTietDatPhong;
import com.example.demo.responsitory.ChiTietDatPhongRepo;
import com.example.demo.service.ChiTietDPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietDPSerImp implements ChiTietDPService {
    @Autowired
    ChiTietDatPhongRepo repo;

    public List<ChiTietDatPhong> getAllChiTietDatPhong() {
        return repo.findAll();
    }
    public ChiTietDatPhong saveChiTietDatPhong(ChiTietDatPhong chiTietDatPhong) {
        return repo.save(chiTietDatPhong);
    }
    public void deleteChiTietDatPhong(Integer id) {
        repo.deleteById(id);
    }

}
