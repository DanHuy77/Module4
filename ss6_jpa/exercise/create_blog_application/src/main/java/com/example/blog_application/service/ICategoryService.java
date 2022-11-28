package com.example.blog_application.service;

import com.example.blog_application.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
}
