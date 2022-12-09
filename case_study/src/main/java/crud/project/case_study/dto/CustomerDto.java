package crud.project.case_study.dto;

import crud.project.case_study.model.Contract;
import crud.project.case_study.model.CustomerType;

import javax.persistence.*;
import javax.validation.Validation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Set;

public class CustomerDto {
    private Integer id;
    @NotBlank(message = "Tên không được là khoảng trống")
    @NotEmpty(message = "Tên không được để trống")
    @Pattern(regexp = "^([A-zAÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐ]" +
            "[a-zaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ]+[ ])+" +
            "([A-ZAÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐ]" +
            "[a-zaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ]+)$", message = "Tên sai định dạng!")
    private String name;
    private Date dateOfBirth;
    private Boolean gender;
    @NotBlank(message = "Số CMND không được là khoảng trống")
    @NotEmpty(message = "Số CMND không được để trống")
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$", message = "Số CMND phải có độ dài không được ngắn hơn 9 hoặc dài hơn 12 số")
    private String idNumber;
    @NotBlank(message = "Số điện thoại không được là khoảng trống")
    @NotEmpty(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(\\+84\\d{9})|(0\\d{9})$", message = "Số điện thoại phải bắt đầu bằng +84 hoặc 0, dãy số sau đó phải có 9 số")
    private String phoneNumber;
    @NotBlank(message = "Email không được là khoảng trống")
    @NotEmpty(message = "Email không được để trống")
    @Pattern(regexp = "^\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b$", message = "Sai định dạng email")
    private String email;
    private String address;
    @ManyToOne
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractSet;

    public CustomerDto() {
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}

