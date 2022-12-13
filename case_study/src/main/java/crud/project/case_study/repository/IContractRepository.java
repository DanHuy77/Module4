package crud.project.case_study.repository;

import crud.project.case_study.dto.ContractDto;
import crud.project.case_study.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "SELECT c.id, c.start_day as startDay, c.end_day as endDay, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue FROM contract c LEFT JOIN details_contract cd ON c.id = cd.contract_id LEFT JOIN attached_service af ON cd.attached_service_list_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY c.id"
            ,countQuery="SELECT c.id, c.start_day as startDay, c.end_day as endDay, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue FROM contract c LEFT JOIN details_contract cd ON c.id = cd.contract_id LEFT JOIN attached_service af ON cd.attached_service_list_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY c.id"
            , nativeQuery = true)
    Page<ContractDto> showContractDtoList(Pageable pageable);

}
