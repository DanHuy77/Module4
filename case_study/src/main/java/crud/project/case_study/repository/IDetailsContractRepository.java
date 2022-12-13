package crud.project.case_study.repository;

import crud.project.case_study.model.AttachedService;
import crud.project.case_study.model.DetailsContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetailsContractRepository extends JpaRepository<DetailsContract, Integer> {
    List<DetailsContract> findDetailsContractByContractId(Integer id);
}
