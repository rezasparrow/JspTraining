package presentation;

import bean.RealCustomer;
import controller.Bundle.RealCustomerBundle;
import util.MessageBundle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RealCustomerView {
    public String firstName;
    public String lastName;
    public String fatherName;
    public String birthday;
    public String nationalCode;
    public String customerNumber;
    public Integer id;


    public RealCustomer toModel() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date date;
        date = df.parse(birthday);
        RealCustomer realCustomer = new RealCustomer(firstName, lastName, fatherName, date, nationalCode);
        realCustomer.setId(id);
        realCustomer.setCustomerNumber(customerNumber);
        return realCustomer;
    }
}
