package crud.project.case_study.model;

import org.hibernate.annotations.Tables;

import javax.persistence.*;
import java.sql.Date;

import static javax.management.Query.value;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private String idNumber;
    private Double salary;
    private String phoneNumber;
    private String email;
    private String address;
    @ManyToOne
    private Position position;
    @ManyToOne
    private EduLevel eduLevel;
    @ManyToOne
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String name, Date dateOfBirth, String idNumber, Double salary, String phoneNumber, String email, String address, Position position, EduLevel eduLevel, Department department) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idNumber = idNumber;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.eduLevel = eduLevel;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EduLevel getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(EduLevel eduLevel) {
        this.eduLevel = eduLevel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
