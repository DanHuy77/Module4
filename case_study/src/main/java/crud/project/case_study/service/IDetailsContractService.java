package crud.project.case_study.service;

import crud.project.case_study.model.DetailsContract;

import java.util.List;

public interface IDetailsContractService extends IGeneralService<DetailsContract> {
    List<DetailsContract> findDetailsContractByContractId(Integer id);
}
