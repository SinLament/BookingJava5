package com.example.demo.service.serviceImpl;


import com.example.demo.entity.DatPhong;
import com.example.demo.entity.KhachSan;
import com.example.demo.entity.KhuyenMai;
import com.example.demo.responsitory.DatPhongRepo;
import com.example.demo.service.DatPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatPhongSerImp implements DatPhongService {
    @Autowired
    DatPhongRepo repo;

    public List<DatPhong> getAllDatPhong() {
        return repo.findAll();
    }
    public DatPhong saveDatPhong(DatPhong DatPhong) {
        return repo.save(DatPhong);
    }
    public void deleteDatPhong(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Object updateDatPhong(DatPhong datPhong) {
        return repo.save(datPhong);
    }

    @Override
    public DatPhong getDatPhongId(Integer maDP) {

        Optional<DatPhong> optionalProduct = repo.findById(maDP);
        return optionalProduct.orElse(null);
    }
}
