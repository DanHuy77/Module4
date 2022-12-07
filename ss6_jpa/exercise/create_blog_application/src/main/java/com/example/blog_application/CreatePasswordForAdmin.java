package com.example.blog_application;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CreatePasswordForAdmin {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("theAdmin"));
    }
}
