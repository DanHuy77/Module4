package crud.project.case_study.service.impl;

import crud.project.case_study.model.Facility;
import crud.project.case_study.model.FacilityType;
import crud.project.case_study.repository.IFacilityRepository;
import crud.project.case_study.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(Integer id) {
        facilityRepository.deleteById(id);
    }


    @Override
    public Page<Facility> findByNameContainingAndFacilityType(String name, FacilityType facilityType, Pageable pageable) {
        return facilityRepository.findByNameContainingAndFacilityType(name, facilityType, pageable);
    }

    @Override
    public Page<Facility> findByNameContaining(String name, Pageable pageable) {
        return facilityRepository.findByNameContaining(name, pageable);
    }
}
