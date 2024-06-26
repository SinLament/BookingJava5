package com.example.demo.service.serviceImpl;

import com.example.demo.controller.entity.DichVu;
import com.example.demo.controller.responsitory.DichVuRepo;
import com.example.demo.controller.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichVuServiceImpl implements DichVuService {

    @Autowired
    private DichVuRepo dichVuRepository;

    @Override
    public List<DichVu> getAllDichVu() {

        return dichVuRepository.findAll();
    }

    @Override
    public DichVu getDichVuById(Long id) {
        Optional<DichVu> optionalDichVu = dichVuRepository.findById(id);
        return optionalDichVu.orElse(null);
    }

    @Override
    public DichVu saveDichVu(DichVu dichVu) {

        return dichVuRepository.save(dichVu);
    }
}
