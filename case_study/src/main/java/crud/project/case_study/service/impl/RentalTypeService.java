package crud.project.case_study.service.impl;

import crud.project.case_study.model.RentalType;
import crud.project.case_study.repository.IRentalTypeRepository;
import crud.project.case_study.service.IRentalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentalTypeService implements IRentalTypeService {

    @Autowired
    private IRentalTypeRepository rentalTypeRepository;

    @Override
    public Page<RentalType> findAll(Pageable pageable) {
        return rentalTypeRepository.findAll(pageable);
    }

    @Override
    public RentalType findById(Integer id) {
        return rentalTypeRepository.findById(id).get();
    }

    @Override
    public void save(RentalType rentalType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
