package com.example.demo.service.serviceImpl;


import com.example.demo.entity.ChiTietDatPhong;
import com.example.demo.entity.DatPhong;
import com.example.demo.responsitory.ChiTietDatPhongRepo;
import com.example.demo.service.ChiTietDPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietDPSerImp implements ChiTietDPService {
    @Autowired
    ChiTietDatPhongRepo repo;
    @Override
    public List<ChiTietDatPhong> getAllChiTietDatPhong() {
        return repo.findAll();
    }
    @Override
    public ChiTietDatPhong saveChiTietDatPhong(ChiTietDatPhong chiTietDatPhong) {
        return repo.save(chiTietDatPhong);
    }
    @Override
    public void deleteChiTietDatPhong(Integer id) {
        repo.deleteById(id);
    }
    @Override
    public Object updateChiTietDatPhong(ChiTietDatPhong ChiTietDatPhong) {
        return repo.save(ChiTietDatPhong);
    }

}
