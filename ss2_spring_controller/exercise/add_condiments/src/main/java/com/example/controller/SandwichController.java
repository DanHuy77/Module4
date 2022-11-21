package com.example.controller;

import com.example.model.Sandwich;
import com.example.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService sandwichService;

    @GetMapping("")
    public String showList(Model model) {
        List<Sandwich> sandwichList = sandwichService.showList();
        model.addAttribute("sandwichList", sandwichList);
        return "list";
    }

    @GetMapping("/add/{id}")
    public String showAddForm(@PathVariable("id") int id, Model model) {
        Sandwich sandwich = sandwichService.findById(id);
        model.addAttribute("sandwich", sandwich);
        return "add";
    }

    @PostMapping("/add")
    public String addCondiments(int id, String condiments, RedirectAttributes redirectAttributes) {
        sandwichService.addCondiment(id, condiments);
        redirectAttributes.addFlashAttribute("message", "Thêm gia vị thành công");
        return "redirect:/";
    }
}
