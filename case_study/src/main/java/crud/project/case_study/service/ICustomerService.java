package crud.project.case_study.service;

import crud.project.case_study.model.Customer;
import crud.project.case_study.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);

    Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

    Page<Customer> showUsingServiceCustomer(Pageable pageable);
}
