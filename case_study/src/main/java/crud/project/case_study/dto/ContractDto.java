package crud.project.case_study.dto;

import crud.project.case_study.model.Customer;
import crud.project.case_study.model.Employee;
import crud.project.case_study.model.Facility;

import java.sql.Date;

public interface ContractDto {
    Integer getId();

    String getNameCustomer();

    String getNameFacility();

    String getStartDay();

    String getEndDay();

    String getDeposit();

    Double getTotalValue();
}
