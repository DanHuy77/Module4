package crud.project.case_study.repository;

import crud.project.case_study.dto.AttachedServiceDto;
import crud.project.case_study.model.AttachedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAttachedServiceRepository extends JpaRepository<AttachedService, Integer> {

    @Query(value = "select attached_service.*, details_contract.quantity from attached_service JOIN details_contract on details_contract.attached_service_list_id = attached_service.id JOIN contract on contract.id = details_contract.contract_id where contract.id = :id"
            , countQuery = "select attached_service.*, details_contract.quantity from attached_service JOIN details_contract on details_contract.attached_service_list_id = attached_service.id JOIN contract on contract.id = details_contract.contract_id where contract.id = :id"
            , nativeQuery = true)
    List<AttachedServiceDto> getAttachServiceList(@Param("id") Integer id);
}
