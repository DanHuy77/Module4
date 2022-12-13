package crud.project.case_study.controller;

import crud.project.case_study.model.DetailsContract;
import crud.project.case_study.service.IDetailsContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/detailsContract")
@Controller
public class DetailsContractController {

    @Autowired
    private IDetailsContractService detailsContractService;

    @GetMapping("")
    public String showDetailsContractList(Model model, Pageable pageable) {
        List<DetailsContract> detailsContractList = detailsContractService.findAll(pageable).getContent();
        model.addAttribute("detailsContractList", detailsContractList);
        return "contract/list";
    }

    @PostMapping("/add")
    public String addAttachList(@ModelAttribute("detailsContract") DetailsContract detailsContract, RedirectAttributes redirectAttributes) {
        detailsContractService.save(detailsContract);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công");
        return "redirect:/contract";
    }

    @PostMapping("/add2")
    public String addAttachAdd(@ModelAttribute("detailsContract") DetailsContract detailsContract, Model model) {
        detailsContractService.save(detailsContract);
        model.addAttribute("message", "Thêm mới hợp đồng chi tiết thành công");
        return "contract/add";
    }


}
