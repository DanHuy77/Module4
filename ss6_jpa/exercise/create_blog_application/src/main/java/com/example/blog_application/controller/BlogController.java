package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showBlogList(Model model) {
        List<Blog> blogList = (List<Blog>) blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("/add")
    public String showAddBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "add";
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
        return "remove";
    }

    @PostMapping("/remove")
    public String removeBlog(Integer id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Removed Blog");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm(Integer id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "edit";
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
        return "view";
    }
}
