package dataaccess;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Dotin School1 on 4/17/2016.
 */

@Entity
@Table(name = "Customer")
public abstract class Customer  {
    @Id
    protected String customerNumber;


}
