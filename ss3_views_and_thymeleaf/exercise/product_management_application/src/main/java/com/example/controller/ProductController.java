package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showProductList(Model model) {
        List<Product> productList = productService.showProductList();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/search")
    public String showSearchResult(String searchName, Model model) {
        List<Product> productList = productService.searchByName(searchName);
        if (!productList.isEmpty()) {
            model.addAttribute("productList", productList);
        } else {
            model.addAttribute("message", "Product not found!");
        }
        return "search_result";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute(new Product());
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.addNewProduct(product);
        redirectAttributes.addFlashAttribute("message", "Added new Product " + product.getName());
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm(Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.editProduct(product);
        redirectAttributes.addFlashAttribute("message", "Edited product " + product.getName());
        return "redirect:/";
    }

    @GetMapping("/details")
    public String showDetails(Integer id, Model model) {
        Product product = productService.findById(id);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        model.addAttribute("productList", productList);
        return "details";
    }

    @PostMapping("/remove")
    public String removeProduct(Integer id, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        productService.removeProduct(product);
        redirectAttributes.addFlashAttribute("message", "Removed product" + product.getName());
        return "redirect:/";
    }
}
