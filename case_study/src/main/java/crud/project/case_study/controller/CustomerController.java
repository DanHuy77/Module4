package crud.project.case_study.controller;

import crud.project.case_study.dto.CustomerDto;
import crud.project.case_study.model.Customer;
import crud.project.case_study.model.CustomerType;
import crud.project.case_study.repository.ICustomerTypeRepository;
import crud.project.case_study.service.ICustomerService;
import crud.project.case_study.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;


    @GetMapping("")
    public String showCustomerList(Model model, @PageableDefault(size = 2, sort = "name") Pageable pageable) {
        Page<Customer> customerList = customerService.findAll(pageable);
        Pageable pageable1 = Pageable.ofSize(5);
        List<CustomerType> customerTypeList = customerTypeService.findAll(pageable1).getContent();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model, Pageable pageable) {
        List<CustomerType> customerTypeList = customerTypeService.findAll(pageable).getContent();
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/add";
    }

    @PostMapping("/add")
    public String addCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Pageable pageable, Model model) {
        if (bindingResult.hasErrors()) {
            List<CustomerType> customerTypeList = customerTypeService.findAll(pageable).getContent();
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypeList", customerTypeList);
            return "customer/add";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới khách hàng thành công");
        return "redirect:/customer";
    }

    @GetMapping("/edit")
    public String showEditForm(Integer id, Model model, Pageable pageable) {
        CustomerDto customerDto = new CustomerDto();
        Customer customer = customerService.findById(id);
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerTypeList", customerTypeService.findAll(pageable).getContent());
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model, Pageable pageable) {
        if (bindingResult.hasErrors()) {
            List<CustomerType> customerTypeList = customerTypeService.findAll(pageable).getContent();
            model.addAttribute("customerDto", customerDto);
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Cập nhật khách hàng thành công");
        return "redirect:/customer";
    }

    @PostMapping("/remove")
    public String removeCustomer(Integer id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Xóa khách hàng thành công");
        return "redirect:/customer";
    }

    @PostMapping("/search")
    public String showSearchResult(@RequestParam(defaultValue = "") String key1,
                                   @RequestParam(defaultValue = "") String key2,
                                   @RequestParam(defaultValue = "-1") Integer key3,
                                   @PageableDefault(sort = "name") Pageable pageable, Model model) {
        try {
            Page<Customer> customerList;
            if (key3 == -1) {
                customerList = customerService.findByNameContainingAndEmailContaining(key1, key2, pageable);
            } else {
                CustomerType customerType = customerTypeService.findById(key3);
                customerList = customerService.findByNameContainingAndEmailContainingAndCustomerType(key1, key2, customerType, pageable);
            }
            Pageable pageable1 = Pageable.ofSize(5);
            List<CustomerType> customerTypeList = customerTypeService.findAll(pageable1).getContent();

            String message = "";
            if (customerList.isEmpty()) {
                message = "Không có khách hàng khớp với tìm kiếm";
            } else {
                message = "Những khách hàng khớp với tìm kiếm";
            }
            model.addAttribute("message", message);
            model.addAttribute("customerTypeList", customerTypeList);
            model.addAttribute("customerList", customerList);
            model.addAttribute("key1", key1);
            model.addAttribute("key2", key2);
            model.addAttribute("key3", key3);
        } catch (NoSuchElementException e) {
            e.getCause();
        }
        return "customer/list";
    }
}
