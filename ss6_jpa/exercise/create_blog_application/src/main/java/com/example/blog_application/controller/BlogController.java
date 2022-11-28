package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import com.example.blog_application.service.IBlogService;
import com.example.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showBlogList(@PageableDefault(page = 0, size = 2, sort = {"blogName"}) Pageable pageable, Model model) {
        Page<Blog> blogList = (Page<Blog>) blogService.findAll(pageable);
        model.addAttribute("blogList", blogList);
        return "blog/list";
    }

    @GetMapping("/add")
    public String showAddBlogForm(Model model, Pageable pageable) {
        Page<Category> categoryList = (Page<Category>) categoryService.findAll(pageable);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());

        return "blog/add";
    }

    @PostMapping("/add")
    public String addBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Added new Blog");
        return "redirect:/";
    }

    @GetMapping("/remove")
    public String showRemoveForm(Integer id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/remove";
    }

    @PostMapping("/remove")
    public String removeBlog(Integer id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Removed Blog");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm(Integer id, Model model, Pageable pageable) {
        Optional<Blog> blog = blogService.findById(id);
        Page<Category> categoryList = (Page<Category>) categoryService.findAll(pageable);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Edited Blog");
        return "redirect:/";
    }

    @GetMapping("/view")
    public String viewBlog(Integer id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/view";
    }

    @GetMapping("/category")
    public String showCategory(Model model, Pageable pageable) {
        Page<Category> categoryList = (Page<Category>) categoryService.findAll(pageable);
        model.addAttribute("categoryList", categoryList);
        return "category/list";
    }

    @GetMapping("/add-category")
    public String showCategoryAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add-category")
    public String addCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Added new Category");
        return "redirect:/category";
    }

    @GetMapping("/edit-category")
    public String showCategoryEditForm(Integer id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit-category")
    public String editCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Edited Category");
        return "redirect:/category";
    }

    @GetMapping("/remove-category")
    public String showRemoveCategoryForm(Integer id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/remove";
    }

    @PostMapping("/remove-category")
    public String removeCategory(Integer id, RedirectAttributes redirectAttributes) {
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Removed Category");
        return "redirect:/category";
    }
}
