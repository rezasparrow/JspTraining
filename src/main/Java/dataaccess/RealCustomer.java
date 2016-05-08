package dataaccess;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RealCustomer")
public class RealCustomer extends Customer {

    @Id @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "first_name" , nullable = false , length = 50)
    public String firstName;

    @Column(name = "last_name" , nullable = false )
    public String lastName;

    @Column(name = "father_name" , nullable = false )
    public String fatherName;

    @Column(name = "birth_day" , nullable = false ,columnDefinition = "DATE")
    public Date birthDay;

    @Column(name = "national_code" , nullable = false  , length = 10)
    public String nationalCode;

    public RealCustomer() {
    }

    public RealCustomer(String firstName, String lastName, String fatherName, Date birthDay, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthDay = birthDay;
        this.nationalCode = nationalCode;
        this.id = 0;
    }

    public RealCustomer(int id, String customerNumber, String firstName, String lastName, String fatherName, Date birthDay, String nationalCode) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthDay = birthDay;
        this.nationalCode = nationalCode;
        this.id = id;
    }



    public String getCustomerNumber() {
        return customerNumber;
    }

    //TODO: save real customer
    public RealCustomer save() {
        return null;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
