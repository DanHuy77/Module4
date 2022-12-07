package com.example.blog_application.service.impl;


import com.example.blog_application.model.MyUserDetails;
import com.example.blog_application.model.User;
import com.example.blog_application.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Bước 4: Tạo service
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = iUserRepository.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User name: " + userName + " not found");
        }

        return new MyUserDetails(user);
    }
}
