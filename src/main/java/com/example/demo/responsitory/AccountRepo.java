package com.example.demo.responsitory;


import com.example.demo.controller.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo  extends JpaRepository<Account, Integer> {
  Account findByUsername(String username);
}
