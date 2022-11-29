package com.example.user_validation.service.impl;

import com.example.user_validation.model.User;
import com.example.user_validation.repository.IUserRepository;
import com.example.user_validation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService<User> {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void remove(Integer id) {
        iUserRepository.deleteById(id);
    }
}
