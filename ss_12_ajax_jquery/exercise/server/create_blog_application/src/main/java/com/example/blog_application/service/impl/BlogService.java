package com.example.blog_application.service.impl;

import com.example.blog_application.model.Blog;
import com.example.blog_application.repository.IBlogRepository;
import com.example.blog_application.repository.ICategoryRepository;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogByBlogNameContaining(String searchKey, Pageable pageable) {
        return blogRepository.findBlogByBlogNameContaining(searchKey, pageable);
    }


}
