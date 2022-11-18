package com.example.controller;

import com.example.service.IConverterService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

@Controller
public class ConvertController {
    @Autowired
    private IConverterService converterService;

    @GetMapping("/convert")
    public String convert() {

        return "convert";
    }

    @PostMapping("/convert_to_usd")
    public String convertToUSD(double vnd, Model model) {
        double result = converterService.toUsd(vnd);
        model.addAttribute("result", result + " $");
        return "convert";
    }

    @PostMapping("/convert_to_vnd")
    public String convertToVND(double usd, Model model) {
        double result = converterService.toVnd(usd);
        model.addAttribute("result", result + " VND");
        return "convert";
    }
}
