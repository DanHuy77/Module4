package crud.project.case_study.model;

import javax.persistence.*;


@Entity
public class DetailsContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    @ManyToOne
    private Contract contract;
    @ManyToOne
    private AttachedService attachedService;

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

    public AttachedService getAttachedService() {
        return attachedService;
    }

    public void setAttachedService(AttachedService attachedService) {
        this.attachedService = attachedService;
    }
}
