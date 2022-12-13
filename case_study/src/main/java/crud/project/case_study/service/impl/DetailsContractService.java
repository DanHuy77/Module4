package crud.project.case_study.service.impl;

import crud.project.case_study.model.DetailsContract;
import crud.project.case_study.repository.IDetailsContractRepository;
import crud.project.case_study.service.IDetailsContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsContractService implements IDetailsContractService {

    @Autowired
    private IDetailsContractRepository detailsContractRepository;

    @Override
    public Page<DetailsContract> findAll(Pageable pageable) {
        return detailsContractRepository.findAll(pageable);
    }

    @Override
    public DetailsContract findById(Integer id) {
        return detailsContractRepository.findById(id).get();
    }

    @Override
    public void save(DetailsContract detailsContract) {
        detailsContractRepository.save(detailsContract);
    }

    @Override
    public void remove(Integer id) {
        detailsContractRepository.deleteById(id);
    }

    @Override
    public List<DetailsContract> findDetailsContractByContractId(Integer id) {
        return detailsContractRepository.findDetailsContractByContractId(id);
    }
}
