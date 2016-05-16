package bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "customer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer implements Serializable , IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id" )
    private int id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(strategy = "uuid" , name = "uuid")
    @Column(name = "customer_number", nullable = false, unique = true, insertable = false, updatable = false)
    private Integer customerNumber;

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
}
