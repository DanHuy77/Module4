package crud.project.case_study.service;

import crud.project.case_study.dto.ContractDto;
import crud.project.case_study.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IContractService extends IGeneralService<Contract> {
    Page<ContractDto> showContractDtoList(Pageable pageable);

    Page<ContractDto> showContractOfCustomer(@Param("id") Integer id, Pageable pageable);
}
