package bean;

import logic.model.RealCustomerView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "real_customer")
@PrimaryKeyJoinColumn(name = "id")
public class RealCustomer extends Customer implements Serializable  {

    @Column(name = "first_name" , nullable = false , length = 50)
    private String firstName;

    @Column(name = "last_name" , nullable = false )
    private String lastName;

    @Column(name = "father_name" , nullable = false )
    private String fatherName;

    @Column(name = "birth_day" , nullable = false )
    private Date birthDay;

    @Column(name = "national_code" , nullable = false  , length = 10)
    private String nationalCode;

    @OneToMany( mappedBy = "customer")
    private Set<LoanFile> loanFiles = new HashSet<>();

    public RealCustomer() {
    }

    public RealCustomer(String firstName, String lastName, String fatherName, Date birthDay, String nationalCode) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthDay = birthDay;
        this.nationalCode = nationalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Set<LoanFile> getLoanFiles() {
        return loanFiles;
    }

    public void setLoanFiles(Set<LoanFile> loanFiles) {
        this.loanFiles = loanFiles;
    }


}
