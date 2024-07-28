package com.example.demo.service;

import com.example.demo.entity.DatPhong;

import java.util.List;

public interface DatPhongService {
    public List<DatPhong> getAllDatPhong();
    public DatPhong saveDatPhong(DatPhong DatPhong);
    public void deleteDatPhong(Integer id);
}
