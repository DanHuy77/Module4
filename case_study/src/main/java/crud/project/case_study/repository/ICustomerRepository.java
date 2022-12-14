package crud.project.case_study.repository;

import crud.project.case_study.dto.CustomerDto;
import crud.project.case_study.model.Contract;
import crud.project.case_study.model.Customer;
import crud.project.case_study.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);

    Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

    @Query(value = "select customer.* from customer join contract on customer.id = contract.customer_id group by customer.id"
            ,countQuery="select customer.* from customer join contract on customer.id = contract.customer_id group by customer.id"
            , nativeQuery = true)
    Page<Customer> showUsingServiceCustomer(Pageable pageable);

}
