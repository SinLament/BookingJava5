package com.example.demo.service.serviceImpl;


import com.example.demo.controller.Entity.Account;
import com.example.demo.controller.Responsitory.AccountRepo;
import com.example.demo.controller.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServicelmpl implements AccountService {

  @Autowired AccountRepo accountRepo;


  @Override
  public Account Register(Account account) {
    return accountRepo.save(account);
  }

  @Override
  public Account Login(String username, String password) {
    // Tìm tài khoản dựa trên tên đăng nhập
    Account account = accountRepo.findByUsername(username);

    // Kiểm tra xem tài khoản có tồn tại và mật khẩu khớp hay không
    if (account != null && account.getPassword().equals(password)) {
      return account; // Đăng nhập thành công, trả về tài khoản
    }

    return null; // Đăng nhập thất bại
  }

}
