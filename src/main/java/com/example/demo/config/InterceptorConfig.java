package com.example.demo.config;

import com.example.demo.utils.AuthInterceptor;
import com.example.demo.utils.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
  @Autowired
  AuthInterceptor auth;

  @Autowired
  GlobalInterceptor global;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    registry.addInterceptor(global)
        .addPathPatterns("/**")
        .excludePathPatterns("/static/**");

    registry.addInterceptor(auth)
        .addPathPatterns("/account/**", "/shop/cart", "/shop/cart/**")
        .excludePathPatterns("/static/**");

  }
}
