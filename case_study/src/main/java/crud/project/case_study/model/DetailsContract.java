package crud.project.case_study.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class DetailsContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    @ManyToOne
    private Contract contract;
    @OneToMany
    private List<AttachedService> attachedServiceList;

    public DetailsContract() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<AttachedService> getAttachedServiceList() {
        return attachedServiceList;
    }

    public void setAttachedServiceList(List<AttachedService> attachedServiceList) {
        this.attachedServiceList = attachedServiceList;
    }
}
