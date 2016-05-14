package presentation;

import bean.RealCustomer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RealCustomerView implements IView<RealCustomer> {
    public String firstName;
    public String lastName;
    public String fatherName;
    public String birthday;
    public String nationalCode;
    public String customerNumber;
    public Integer id;


    public RealCustomer toModel() {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;

        try {
            if (birthday != null) {
                date = df.parse(birthday);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RealCustomer realCustomer = new RealCustomer(firstName, lastName, fatherName, date, nationalCode);
        if (id != null) {
            realCustomer.setId(id);
        }
        if(customerNumber != null)
        {
            realCustomer.setCustomerNumber(Integer.parseInt(customerNumber));
        }

        return realCustomer;
    }

    public String getFirstName() {
        return firstName !=null ? firstName : "";
    }

    public String getLastName() {
        return lastName != null ? lastName : "";
    }

    public String getFatherName() {
        return fatherName != null ? fatherName : "";
    }

    public String getBirthday() {
        return birthday!= null ? birthday : "";
    }

    public String getNationalCode() {
        return nationalCode!= null ? nationalCode : "";
    }

    public String getCustomerNumber() {
        return customerNumber!= null ? customerNumber : "";
    }

    public Integer getId() {
        return id;
    }

    public static RealCustomerView toView(RealCustomer realCustomer) {
        RealCustomerView view = new RealCustomerView();
        view.id = realCustomer.getId();
        view.customerNumber = realCustomer.getCustomerNumber().toString();
        view.firstName = realCustomer.getFirstName();
        view.lastName = realCustomer.getLastName();
        view.fatherName = realCustomer.getFatherName();
        view.nationalCode = realCustomer.getNationalCode();
        view.birthday = realCustomer.getBirthDay().toString();

        return view;
    }
}
