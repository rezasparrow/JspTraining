package bean;

import dataaccess.IEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grant_condition")
@Embeddable
public class GrantCondition implements Serializable , IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public GrantCondition(){

    }

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "max_duration" , nullable = false)
    private Integer maxDuration;

    @Column(name = "min_duration" , nullable = false)
    private Integer minDuration;

    @Column(name = "max_amount" , nullable = false)
    private Integer maxAmount;

    @Column(name = "min_amount" , nullable = false)
    private Integer minAmount;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_type_id", nullable = false)
    private LoanType loanType;

    public GrantCondition(String name, Integer maxDuration, Integer minDuration, Integer maxAmount, Integer minAmount, LoanType loanType) {
        this.name = name;
        this.maxDuration = maxDuration;
        this.minDuration = minDuration;
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.loanType = loanType;
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

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxAmount = maxDuration;
    }

    public Integer getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }
}
