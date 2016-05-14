package bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "loan_file")
@Embeddable
public class LoanFile implements Serializable , IEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private RealCustomer customer;


    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_type_id", nullable = false)
    private LoanType loanType;

    public LoanFile(){

    }

    public LoanFile(RealCustomer customer){
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RealCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(RealCustomer customer) {
        this.customer = customer;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }
}
