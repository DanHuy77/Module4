package com.example.blog_application.repository;

import com.example.blog_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
