package com.example.customer_manager.controller;

import com.example.customer_manager.model.Customer;
import com.example.customer_manager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller

public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String showCustomerList(Model model) {
        Iterable<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add";
    }

    @PostMapping("/add")
    public String addNewCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Added new Customer");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEditForm(Long id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edited Customer");
        return "redirect:/";
    }

    @GetMapping("/remove")
    public String showRemoveForm(Long id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "removes";
    }

    @PostMapping("/remove")
    public String removeCustomer(Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Removed Customer");
        return "redirect:/";
    }
}
