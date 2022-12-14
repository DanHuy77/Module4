package crud.project.case_study.controller;

import crud.project.case_study.dto.ContractDto;
import crud.project.case_study.model.*;
import crud.project.case_study.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;
    @Autowired
    private IDetailsContractService detailsContractService;
    @Autowired
    private IAttachedServiceService attachedServiceService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public String showContractList(Model model, Pageable pageable) {
        Page<ContractDto> contractDtoList = contractService.showContractDtoList(pageable);
        List<DetailsContract> detailsContractList = detailsContractService.findAll(pageable).getContent();
        List<AttachedService> attachedServiceList = attachedServiceService.findAll(pageable).getContent();

        model.addAttribute("attachedServiceList", attachedServiceList);
        model.addAttribute("detailsContractList", detailsContractList);
        model.addAttribute("contractDtoList", contractDtoList);
        model.addAttribute("detailsContract", new DetailsContract());

        for (int i = 0; i < contractDtoList.getContent().size(); i++) {
            if (contractDtoList.getContent().get(i).getNameCustomer() == null ||
                    contractDtoList.getContent().get(i).getNameFacility() == null) {
                contractService.remove(contractDtoList.getContent().get(i).getId());
            }
        }
        return "contract/list";
    }

    @GetMapping("/add")
    public String showAddContractForm(Model model, Pageable pageable) {
        List<Customer> customerList = customerService.findAll(pageable).getContent();
        List<Facility> facilityList = facilityService.findAll(pageable).getContent();
        List<Employee> employeeList = employeeService.findAll(pageable).getContent();
        List<AttachedService> attachedServiceList = attachedServiceService.findAll(pageable).getContent();
        Contract contract = new Contract();
        contractService.save(contract);
        model.addAttribute(contract);
        model.addAttribute(new DetailsContract());
        model.addAttribute("customerList", customerList);
        model.addAttribute("facilityList", facilityList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("attachedServiceList", attachedServiceList);
        return "contract/add";
    }

    @PostMapping("/add")
    public String addContract(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng thành công");
        return "redirect:/contract";
    }

    @GetMapping("/contract-of-customer")
    public String showContractOfCustomer(Model model, Integer id, @PageableDefault(size = 5) Pageable pageable) {
        Page<ContractDto> contractDtoList = contractService.showContractOfCustomer(id, pageable);
        List<DetailsContract> detailsContractList = detailsContractService.findAll(pageable).getContent();
        List<AttachedService> attachedServiceList = attachedServiceService.findAll(pageable).getContent();

        model.addAttribute("attachedServiceList", attachedServiceList);
        model.addAttribute("detailsContractList", detailsContractList);
        model.addAttribute("detailsContract", new DetailsContract());
        model.addAttribute("contractDtoList", contractDtoList);
        return "contract/list";
    }
}
