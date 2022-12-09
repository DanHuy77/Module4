package crud.project.case_study.repository;

import crud.project.case_study.dto.CustomerDto;
import crud.project.case_study.model.Customer;
import crud.project.case_study.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);

    Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);
}
