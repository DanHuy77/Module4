package com.example.user_validation.repository;

import com.example.user_validation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
