package crud.project.case_study.service.impl;

import crud.project.case_study.model.FacilityType;
import crud.project.case_study.repository.IFacilityTypeRepository;
import crud.project.case_study.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public Page<FacilityType> findAll(Pageable pageable) {
        return facilityTypeRepository.findAll(pageable);
    }

    @Override
    public FacilityType findById(Integer id) {
        return facilityTypeRepository.findById(id).get();
    }

    @Override
    public void save(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }

    @Override
    public void remove(Integer id) {
        facilityTypeRepository.deleteById(id);
    }
}
