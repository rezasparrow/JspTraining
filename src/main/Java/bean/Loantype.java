package bean;

import dataaccess.IEntity;
import org.intellij.lang.annotations.JdkConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "loan_type")
public class LoanType implements Serializable, IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name" ,  nullable = false )
    private String name;

    @Column(name = "rate" , nullable = false)
    private float rate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loanType")
    private Set<LoanFile> loanFiles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loanType")
    private Set<GrantCondition> grantConditions ;

    public LoanType() {
        grantConditions = new HashSet<>();
    }

    public LoanType(String name, float rate) {
        grantConditions = new HashSet<>();
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Set<LoanFile> getLoanFiles() {
        return loanFiles;
    }

    public void setLoanFiles(Set<LoanFile> loanFiles) {
        this.loanFiles = loanFiles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(Set<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }

    public void addGrandCondition(GrantCondition grantCondition){
        grantConditions.add(grantCondition);
    }
}
