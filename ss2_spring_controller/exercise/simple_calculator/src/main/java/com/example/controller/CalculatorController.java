package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculatorController {

    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("")
    public String show() {
        return "calculator";
    }

    @PostMapping("/cal")
    public String calculate(double num1, double num2, String operator, Model model) {
        double result = calculatorService.calculate(num1, num2, operator);
        model.addAttribute("result", "Result = " + result);
        return "calculator";
    }
}
