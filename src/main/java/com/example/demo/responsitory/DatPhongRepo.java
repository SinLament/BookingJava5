package com.example.demo.responsitory;


import com.example.demo.entity.DatPhong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatPhongRepo  extends JpaRepository<DatPhong, Integer> {

}
