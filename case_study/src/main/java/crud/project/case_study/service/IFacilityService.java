package crud.project.case_study.service;

import crud.project.case_study.model.Facility;
import crud.project.case_study.model.FacilityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService extends IGeneralService<Facility> {
    Page<Facility> findByNameContainingAndFacilityType(String name, FacilityType facilityType, Pageable pageable);

    Page<Facility> findByNameContaining(String name, Pageable pageable);
}
