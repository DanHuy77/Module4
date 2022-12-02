package com.example.shopping.controller;

import com.example.shopping.dto.CartDto;
import com.example.shopping.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("")
    public String showCart(@SessionAttribute("cart") CartDto cartDto, Model model) {
        model.addAttribute("cartDto", cartDto);
        return "cart/list";
    }


    @GetMapping("/confirm")
    public String confirm(@SessionAttribute("cart") CartDto cartDto, RedirectAttributes redirectAttributes) {
        cartDto.getProductMap().clear();
        redirectAttributes.addFlashAttribute("message", "Payment Succeed");
        return "redirect:/";
    }
}
