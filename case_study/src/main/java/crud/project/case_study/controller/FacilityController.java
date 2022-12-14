package crud.project.case_study.controller;

import crud.project.case_study.dto.FacilityDto;
import crud.project.case_study.model.Facility;
import crud.project.case_study.model.FacilityType;
import crud.project.case_study.model.RentalType;
import crud.project.case_study.service.IFacilityService;
import crud.project.case_study.service.IFacilityTypeService;
import crud.project.case_study.service.IRentalTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentalTypeService rentalTypeService;

    @GetMapping("")
    public String showFacilityList(@PageableDefault(size = 4) Pageable pageable, Model model) {
        Page<Facility> facilityList = facilityService.findAll(pageable);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll(pageable).getContent();
        List<RentalType> rentalTypeList = rentalTypeService.findAll(pageable).getContent();

        model.addAttribute("facilityList", facilityList);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentalTypeList", rentalTypeList);

        return "facility/list";
    }

    @GetMapping("/add")
    public String showAddFacilityForm(Model model, Pageable pageable) {
        model.addAttribute("facilityDto", new FacilityDto());

        List<FacilityType> facilityTypeList = facilityTypeService.findAll(pageable).getContent();
        List<RentalType> rentalTypeList = rentalTypeService.findAll(pageable).getContent();

        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentalTypeList", rentalTypeList);
        return "facility/add";
    }

    @PostMapping("/add")
    public String addNewFacility(@ModelAttribute("facilityDto") FacilityDto facilityDto, RedirectAttributes redirectAttributes) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Th??m m???i c?? s??? d???ch v??? th??nh c??ng");
        return "redirect:/facility";
    }

    @PostMapping("/remove")
    public String removeFacility(Integer id, RedirectAttributes redirectAttributes) {
        facilityService.remove(id);
        redirectAttributes.addFlashAttribute("message", "X??a c?? s??? d???ch v??? th??nh c??ng");
        return "redirect:/facility";
    }

    @GetMapping("/edit")
    public String showEditFacilityForm(Integer id, Model model, Pageable pageable) {
        Facility facility = facilityService.findById(id);
        model.addAttribute("facility", facility);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll(pageable).getContent();
        List<RentalType> rentalTypeList = rentalTypeService.findAll(pageable).getContent();
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentalTypeList", rentalTypeList);
        return "facility/edit";
    }

    @PostMapping("/edit")
    public String editFacility(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "C???p nh???t c?? s??? d???ch v??? th??nh c??ng");
        return "redirect:/faciltiy";
    }

    @PostMapping("/search")
    public String showSearchResult(@RequestParam(defaultValue = "") String key1, @RequestParam(defaultValue = "-1") Integer key2, @PageableDefault(size = 4) Pageable pageable, Model model) {
        Page<Facility> facilityList;
        String message = "";
        if (key2 == -1) {
            facilityList = facilityService.findByNameContaining(key1, pageable);
        } else {
            FacilityType facilityType = facilityTypeService.findById(key2);
            facilityList = facilityService.findByNameContainingAndFacilityType(key1, facilityType, pageable);
        }
        List<FacilityType> facilityTypeList = facilityTypeService.findAll(pageable).getContent();

        if (facilityList.isEmpty()) {
            message = "Kh??ng t??m th???y c?? s??? d???ch v??? kh???p v???i t??m ki???m";
        } else {
            message = "Nh???ng c?? s??? d???ch v??? kh???p v???i t??m ki???m";
        }

        model.addAttribute("facilityList", facilityList);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("message", message);
        return "facility/list";
    }
}
