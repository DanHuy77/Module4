package com.example.controller;

import com.example.model.EmailSettings;
import com.example.service.IEmailSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmailSettingsController {
    @Autowired
    private IEmailSettingsService emailSettingsService;

    @GetMapping("")
    public String showSetting(Model model) {

        EmailSettings emailSettings = emailSettingsService.show();


        model.addAttribute("emailSettings", emailSettings);

        return "settings";
    }

    @GetMapping("/setting")
    public String cancel(Model model) {
        EmailSettings emailSettings = emailSettingsService.show();
        model.addAttribute("emailSettings", emailSettings);
        model.addAttribute("message", "Nothing changed");
        return "settings";
    }


    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        List<String> language = emailSettingsService.showLanguage();
        List<Integer> pageSize = emailSettingsService.showPageSize();
        EmailSettings emailSettings = emailSettingsService.show();
        model.addAttribute("language", language);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("emailSettings", emailSettings);
        return "update";
    }

    @PostMapping("/update")
    public String update(EmailSettings emailSettings, RedirectAttributes redirectAttributes) {
        emailSettingsService.update(emailSettings);
        redirectAttributes.addFlashAttribute("message", "Updated");
        return "redirect:/";
    }

}

