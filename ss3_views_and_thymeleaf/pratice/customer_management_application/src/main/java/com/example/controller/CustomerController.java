package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String showList(Model model) {
        List<Customer> customerList = customerService.showCustomerList();
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @GetMapping("customer/add")
    public String showAddForm(Model model) {
        model.addAttribute(new Customer());
        return "customer/add";
    }

    @PostMapping("customer/add")
    public String addCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        boolean check = customerService.add(customer);
        if (check) {
            redirectAttributes.addFlashAttribute("message", "Success");
        }
        return "redirect:/";
    }

    @GetMapping("customer/update")
    public String showUpdateForm(int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/update";
    }

    @PostMapping("customer/update")
    public String update(Customer customer, int id, RedirectAttributes redirectAttributes) {
        boolean check = customerService.update(id, customer);
        if (check) {
            redirectAttributes.addFlashAttribute("message", "Updated");
        }
        return "redirect:/";
    }

    @GetMapping("customer/details")
    public String showDetails(int id, Model model) {
        Customer customer = customerService.findById(id);
        List<Customer> details = new ArrayList<>();
        details.add(customer);
        model.addAttribute("customerList", details);
        return "customer/details";
    }

    @PostMapping("customer/remove")
    public String removeCustomer(int id, RedirectAttributes redirectAttributes) {
        boolean check = customerService.remove(id);
        if (check) {
            redirectAttributes.addFlashAttribute("message", "Removed");
        }
        return "redirect:/";
    }
}
