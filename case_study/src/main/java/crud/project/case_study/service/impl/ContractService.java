package crud.project.case_study.service.impl;

import crud.project.case_study.dto.ContractDto;
import crud.project.case_study.model.Contract;
import crud.project.case_study.repository.IContractRepository;
import crud.project.case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<ContractDto> showContractDtoList(Pageable pageable) {
        return contractRepository.showContractDtoList(pageable);
    }
}
