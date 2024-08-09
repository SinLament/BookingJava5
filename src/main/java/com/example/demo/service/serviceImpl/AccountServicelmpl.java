package com.example.demo.service.serviceImpl;



import com.example.demo.controller.LoginController;
import com.example.demo.entity.Account;
import com.example.demo.responsitory.AccountRepo;
import com.example.demo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.ErrorManager;

@Service
public class AccountServicelmpl implements AccountService {

  @Autowired
  AccountRepo accountRepo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  private static final Logger logger = LoggerFactory.getLogger(AccountServicelmpl.class);
  @Override
  public Account Register(Account account) {

    try{
      String encodedPassword = passwordEncoder.encode(account.getPassword());
      account.setPassword(encodedPassword);
      return accountRepo.save(account);
    }catch (Exception e){
      logger.error("Lỗi khi đăng ký người dùng:", e);
      throw new RuntimeException("Đăng ký thất bại");
    }

  }

  @Override
  public Account Login(String username, String password) {
    try {
      Account account = accountRepo.findByUsername(username);
      if (account != null && passwordEncoder.matches(password, account.getPassword())) {

        return account;
      }
    } catch (Exception e) {
      logger.error("Lỗi khi đăng nhập:", e);
      throw new RuntimeException("Đăng nhập thất bại do lỗi hệ thống");
    }
    return null;
  }



  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account account = accountRepo.findByUsername(username);

    if (account == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
    return
    account;
  }
}
