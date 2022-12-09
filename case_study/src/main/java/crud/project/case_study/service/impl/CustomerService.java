package crud.project.case_study.service.impl;

import crud.project.case_study.dto.CustomerDto;
import crud.project.case_study.model.Customer;
import crud.project.case_study.model.CustomerType;
import crud.project.case_study.repository.ICustomerRepository;
import crud.project.case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    public Page<Customer> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContainingAndCustomerType(name, email, customerType, pageable);
    }

    public Page<Customer> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContaining(name, email, pageable);
    }
}
