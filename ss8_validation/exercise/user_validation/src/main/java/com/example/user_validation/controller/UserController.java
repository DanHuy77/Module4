package com.example.user_validation.controller;

import com.example.user_validation.model.User;
import com.example.user_validation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private IUserService<User> userService;

    @GetMapping("")
    public String showList(Model model, Pageable pageable) {
        Page<User> userList = (Page<User>) userService.findAll(pageable);
        model.addAttribute("userList", userList);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("/add")
    public String addUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new User().validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "add";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Added new User");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm(Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Added new User");
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String removeUser(Integer id, RedirectAttributes redirectAttributes) {
        userService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Removed User");
        return "redirect:/";
    }
}
