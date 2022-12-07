package crud.project.case_study.controller;

import crud.project.case_study.model.Employee;
import crud.project.case_study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public String showEmployeeList(Model model) {
        Pageable pageable = Pageable.ofSize(5);

        Page<Employee> employeeList = employeeService.findAll(pageable);

        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }
}
