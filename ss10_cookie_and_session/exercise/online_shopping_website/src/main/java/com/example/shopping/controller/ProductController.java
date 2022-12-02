package com.example.shopping.controller;

import com.example.shopping.dto.CartDto;
import com.example.shopping.dto.ProductDto;
import com.example.shopping.model.Product;
import com.example.shopping.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("/cart-list")
    public String showCart(@SessionAttribute("cart") CartDto cartDto, Model model) {
        model.addAttribute("cartDto", cartDto);
        return "cart/list";
    }

    @GetMapping("/details")
    public String showDetails(Integer id, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("productId", String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", productService.findById(id));
        return "product/details";
    }

    @GetMapping("")
    public String showProductList(Model model, @CookieValue(value = "productId", defaultValue = "-1") Integer id, Pageable pageable) {
        if (id != -1) {
            model.addAttribute("adProduct", productService.findById(id));
        }
        model.addAttribute("productList", productService.findAll(pageable));
        return "product/list";
    }

    @GetMapping("/add")
    public String addToCart(Integer id, @SessionAttribute("cart") CartDto cartDto, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cartDto.addProduct(productDto);
        redirectAttributes.addFlashAttribute("message", "Added " + product.getName() + " to Cart");
        return "redirect:/";
    }

    @GetMapping("/plus")
    public String plusProduct(Integer id, @SessionAttribute("cart") CartDto cartDto) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cartDto.addProduct(productDto);
        return "redirect:/cart";
    }

    @GetMapping("/minus")
    public String minusProduct(Integer id, @SessionAttribute("cart") CartDto cartDto) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cartDto.removeProduct(productDto);
        return "redirect:/cart";
    }


    @GetMapping("/pay")
    public String totalPayment(Model model, @SessionAttribute("cart") CartDto cartDto) {
        double total = cartDto.getTotal();
        model.addAttribute("total", total);
        return "product/total";
    }
}
