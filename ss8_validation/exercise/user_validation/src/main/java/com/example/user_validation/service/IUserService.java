package com.example.user_validation.service;

import com.example.user_validation.model.User;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService<T> {
    Iterable<T> findAll(Pageable pageable);

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
