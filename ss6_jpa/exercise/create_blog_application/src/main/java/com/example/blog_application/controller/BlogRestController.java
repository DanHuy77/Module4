package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.model.Category;
import com.example.blog_application.service.IBlogService;
import com.example.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Set;

@Controller
@CrossOrigin("*")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

//    Yêu cầu 1

    @GetMapping("")
    public String showBlogList(@PageableDefault(page = 0, size = 2, sort = {"blogName"}) Pageable pageable, Model model) {
        Page<Blog> blogPage = blogService.findAll(pageable);
        model.addAttribute("blogList", blogPage);
        return "blog/list";
    }

    @GetMapping("/blogService")
    public ResponseEntity<Page<Blog>> showBlogServiceList(@PageableDefault(page = 0, size = 2, sort = {"blogName"}) Pageable pageable, Model model) {
        Page<Blog> blogList = blogService.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/add")
    public String showAddBlogForm(Model model, Pageable pageable) {
        Page<Category> categoryList = categoryService.findAll(pageable);
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
//
//    @GetMapping("/remove")
//    public String showRemoveForm(Integer id, Model model) {
//        Blog blog = blogService.findById(id);
//        model.addAttribute("blog", blog);
//        return "blog/remove";
//    }
//
//    @PostMapping("/remove")
//    public String removeBlog(Integer id, RedirectAttributes redirectAttributes) {
//        blogService.remove(id);
//        redirectAttributes.addFlashAttribute("message", "Removed Blog");
//        return "redirect:/";
//    }
//
//    @GetMapping("/edit")
//    public String showEditForm(Integer id, Model model, Pageable pageable) {
//        Blog blog = blogService.findById(id);
//        Page<Category> categoryList = categoryService.findAll(pageable);
//        model.addAttribute("categoryList", categoryList);
//        model.addAttribute("blog", blog);
//        return "blog/edit";
//    }
//
//    @PostMapping("/edit")
//    public String editBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
//        blogService.save(blog);
//        redirectAttributes.addFlashAttribute("message", "Edited Blog");
//        return "redirect:/";
//    }

//    Yêu cầu 2

    @GetMapping(path = "/view/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    Yêu cầu 3

    @GetMapping("/category")
    public ResponseEntity<Page<Category>> showCategory(Pageable pageable) {
        Page<Category> categoryList = categoryService.findAll(pageable);
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

//    @GetMapping("/add-category")
//    public String showCategoryAddForm(Model model) {
//        model.addAttribute("category", new Category());
//        return "category/add";
//    }
//
//    @PostMapping("/add-category")
//    public String addCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
//        categoryService.save(category);
//        redirectAttributes.addFlashAttribute("message", "Added new Category");
//        return "redirect:/category";
//    }
//
//    @GetMapping("/edit-category")
//    public String showCategoryEditForm(Integer id, Model model) {
//        Category category = categoryService.findById(id);
//        model.addAttribute("category", category);
//        return "category/edit";
//    }
//
//    @PostMapping("/edit-category")
//    public String editCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
//        categoryService.save(category);
//        redirectAttributes.addFlashAttribute("message", "Edited Category");
//        return "redirect:/category";
//    }
//
//    @GetMapping("/remove-category")
//    public String showRemoveCategoryForm(Integer id, Model model) {
//        Category category = categoryService.findById(id);
//        model.addAttribute("category", category);
//        return "category/remove";
//    }
//
//    @PostMapping("/remove-category")
//    public String removeCategory(Integer id, RedirectAttributes redirectAttributes) {
//        categoryService.remove(id);
//        redirectAttributes.addFlashAttribute("message", "Removed Category");
//        return "redirect:/category";
//    }

//    Yêu cầu 4

    @GetMapping(path = "/group-by-cate/{id}")
    public ResponseEntity<Set<Blog>> showBlogSet(@PathVariable("id") Integer id) {
        Set<Blog> blogSet = categoryService.findById(id).getBlog();
        if (blogSet.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogSet, HttpStatus.OK);
    }


//    Ajax & Jquery

    @GetMapping(path = "/search/{key}")
    public ResponseEntity<Page<Blog>> showResult(@PathVariable("key") String searchKey) {
        Pageable pageable = Pageable.ofSize(5);
        Page<Blog> blogPage = blogService.findBlogByBlogNameContaining(searchKey, pageable);

        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
}
