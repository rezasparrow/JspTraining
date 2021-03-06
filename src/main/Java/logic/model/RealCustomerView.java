package logic.model;

import bean.LoanFile;
import bean.RealCustomer;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


public class RealCustomerView implements IView<RealCustomer>, Serializable {
    public String firstName;
    public String lastName;
    public String fatherName;
    public String birthday;
    public String nationalCode;
    public Integer customerNumber;
    public Integer id;

    private List<LoanFile> loanFiles;


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
        if (customerNumber != null) {
            realCustomer.setCustomerNumber(customerNumber);
        }

        return realCustomer;
    }

    @Override
    public boolean isValid() {
        if (firstName != null || "".equals(firstName.trim())) {
            return false;
        }
        if (lastName != null || "".equals(lastName.trim())) {
            return false;
        }
        if (fatherName != null || "".equals(fatherName.trim())) {
            return false;
        }
        if (birthday != null || "".equals(birthday.trim())) {
            return false;
        } else {
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            Date date = null;

            try {
                if (birthday != null) {
                    date = df.parse(birthday);
                }
            } catch (ParseException e) {
                return false;
            }
        }
        if (firstName != null || "".equals(firstName.trim())) {
            return false;
        }
        return true;
    }

    public String getFirstName() {
        return firstName != null ? firstName : "";
    }

    public String getLastName() {
        return lastName != null ? lastName : "";
    }

    public String getFatherName() {
        return fatherName != null ? fatherName : "";
    }

    public String getBirthday() {
        return birthday != null ? birthday : "";
    }

    public String getNationalCode() {
        return nationalCode != null ? nationalCode : "";
    }

    public Integer getCustomerNumber() {
        return customerNumber != null ? customerNumber : null;
    }


    public static RealCustomerView toView(RealCustomer realCustomer) {
        RealCustomerView view = new RealCustomerView();
        view.id = realCustomer.getId();
        view.customerNumber = realCustomer.getCustomerNumber();
        view.firstName = realCustomer.getFirstName();
        view.lastName = realCustomer.getLastName();
        view.fatherName = realCustomer.getFatherName();
        view.nationalCode = realCustomer.getNationalCode();
        view.birthday = realCustomer.getBirthDay().toString();

        return view;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<LoanFile> getLoanFiles() {
        return loanFiles == null ? new ArrayList<>() : loanFiles;
    }

    public void setLoanFiles(List<LoanFile> loanFiles) {
        this.loanFiles = loanFiles;
    }

    public String getRealName() {
        return firstName + "  " + lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
