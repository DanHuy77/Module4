package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DictionaryController {
    @Autowired
    public IDictionaryService dictionaryService;

    @GetMapping("")
    public String dic() {
        return "dictionary";
    }

    @PostMapping("/search")
    public String search(String word, Model model) {
        String result = dictionaryService.show(word);
        model.addAttribute("result","Kết quả: " + result);
        return "dictionary";
    }
}
