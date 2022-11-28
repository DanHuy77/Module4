package com.example.blog_application.service.impl;

import com.example.blog_application.model.Category;
import com.example.blog_application.repository.ICategoryRepository;
import com.example.blog_application.service.ICategoryService;
import com.example.blog_application.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
