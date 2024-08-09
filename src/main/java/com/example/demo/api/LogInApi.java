//package com.example.demo.api;
//
//
//import com.example.demo.controller.LoginController;
//import com.example.demo.entity.KhachHang;
//import com.example.demo.responsitory.KhachHangRepo;
//import jakarta.servlet.http.HttpServletRequest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Date;
//
//
//
//@Controller
//
//public class LogInApi {
//    @Autowired
//    private KhachHangRepo khachHangRepo;
//    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @PostMapping("/login")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        Model model,
//                        HttpServletRequest request) {
//
//        KhachHang user = khachHangRepo.findKhachHangByUsername(username);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            model.addAttribute("loginSuccess", true);
//            logger.info("Đăng nhập thành công cho người dùng: {}", username);
//            request.getSession().setAttribute("user", user);
//            return "redirect:/home2";
//        } else {
//            model.addAttribute("loginSuccess", false);
//            logger.error("Đăng nhập thất bại cho người dùng: {}", username);
//
//            return "account/DangNhap";
//        }
//    }
//
////    @GetMapping("/login")
////    public String index(Model model) {
////        return "account/DangNhap";
////    }
//////
////    @GetMapping("/home")
////    public String home(Model model) {
////        return "home";
////    }
//
//
//
//
//
//
//@GetMapping("/register")
//        public String signup(Model model) {
//        return "account/DangKy";
//    }
//
//
//    @PostMapping("/register")
//    public String register(@RequestParam("username") String username,
//                           @RequestParam("password") String password,
//                           @RequestParam("name") String fullname,
//                           @RequestParam("gender") Boolean gender,
//                           @RequestParam("birthday") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,
//                           @RequestParam("address") String address,
//                           @RequestParam("email") String email,
//                           @RequestParam("sdt") String sdt,
//                           Model model) {
//
//        KhachHang existingUser = khachHangRepo.findKhachHangByUsername(username);
//
//        if (existingUser == null) {
//            KhachHang newUser = new KhachHang();
//            newUser.setUsername(username);
//            newUser.setPassword(password);
//            newUser.setFullname(fullname);
//            newUser.setGender(gender);
//            newUser.setBirthday(birthday);
//            newUser.setAddress(address);
//            newUser.setEmail(email);
//            newUser.setSdt(sdt);
//            khachHangRepo.save(newUser);
//
//            model.addAttribute("registrationSuccess", true);
//            logger.info("Đăng ký thành công cho người dùng: {}", username);
//            return "redirect:/login"; // Chuyển hướng đến trang đăng nhập sau khi đăng ký thành công
//        } else {
//            model.addAttribute("registrationSuccess", false);
//            logger.error("Đăng ký thất bại: Người dùng đã tồn tại với tên đăng nhập: {}", username);
//            return "account/DangKy"; // Hiển thị lại trang đăng ký nếu thất bại
//        }
//    }
//}
//
//
//
