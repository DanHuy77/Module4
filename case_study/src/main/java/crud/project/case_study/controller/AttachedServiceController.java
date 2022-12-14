package crud.project.case_study.controller;

import crud.project.case_study.dto.AttachedServiceDto;
import crud.project.case_study.service.impl.AttachedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attachedService")
public class AttachedServiceController {

    @Autowired
    private AttachedServiceService attachedServiceService;

    @GetMapping("/{id}")
    public ResponseEntity<List<AttachedServiceDto>> showAttachedServiceList(@PathVariable("id") Integer id) {
        List<AttachedServiceDto> attachedServiceDtoList = attachedServiceService.getAttachServiceList(id);
        if (attachedServiceDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attachedServiceDtoList, HttpStatus.OK);
        }
    }
}
