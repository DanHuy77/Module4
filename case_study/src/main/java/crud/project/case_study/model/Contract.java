package crud.project.case_study.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date startDay;
    private Date endDay;
    private Double deposit;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Facility facility;
    @OneToMany
    private List<DetailsContract> detailsContractSet;


    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() { return employee;}

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Contract(Integer id, Date startDay, Date endDay, Double deposit, Employee employee, Customer customer, Facility facility, List<DetailsContract> detailsContractSet) {
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.detailsContractSet = detailsContractSet;
    }

    public List<DetailsContract> getDetailsContractSet() {
        return detailsContractSet;
    }

    public void setDetailsContractSet(List<DetailsContract> detailsContractSet) {
        this.detailsContractSet = detailsContractSet;
    }
}
