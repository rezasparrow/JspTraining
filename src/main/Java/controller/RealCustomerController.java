package controller;


import bean.RealCustomer;
import controller.Bundle.RealCustomerBundle;
import dataaccess.RealCustomerManager;
import exception.NotFoundObjectException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import presentation.RealCustomerView;
import util.MessageBundle;

import javax.persistence.Id;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RealCustomerController {

    public static MessageBundle save(RealCustomerView realCustomerView) {
        MessageBundle errors = validate(realCustomerView);
        errors.addAll(validateNationalCode(realCustomerView.nationalCode));
        if (errors.isValid()) {

            RealCustomerManager realCustomerManager = new RealCustomerManager();
            RealCustomer realCustomer = realCustomerView.toModel();
            realCustomerManager.create(realCustomer);


        }
        return errors;
    }

    public static List<RealCustomer> all() {
        RealCustomerManager realCustomerManager = new RealCustomerManager();
        return realCustomerManager.all();
    }

    private static MessageBundle validate(RealCustomerView realCustomerView) {
        MessageBundle errors = new MessageBundle();
        if (realCustomerView.firstName == null || realCustomerView.firstName.trim().length() == 0) {
            errors.addError("firstName", RealCustomerBundle.FIRST_NAME_REQUIRED);
        }
        if (realCustomerView.lastName == null || realCustomerView.lastName.trim().length() == 0) {
            errors.addError("lastName", RealCustomerBundle.LAST_NAME_REQUIRED);
        }
        if (realCustomerView.fatherName == null || realCustomerView.fatherName.trim().length() == 0) {
            errors.addError("fatherName", RealCustomerBundle.FATHER_NAME_REQUIRED);
        }
        if (realCustomerView.nationalCode == null || realCustomerView.nationalCode.trim().length() == 0) {
            errors.addError("nationalCode", RealCustomerBundle.NATIONAL_CODE_REQUIRED);
        } else if (realCustomerView.nationalCode.length() != 10) {
            errors.addError("nationalCode", RealCustomerBundle.NATIONAL_CODE_LENGTH);
        }

        if (realCustomerView.birthday == null || realCustomerView.birthday.trim().length() == 0) {
            errors.addError("birthday", RealCustomerBundle.BIRTHDAY_REQUIRED);
        } else {
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            Date startDate;
            try {
                startDate = df.parse(realCustomerView.birthday);

                df.format(startDate);
            } catch (ParseException e) {
                errors.addError("birthday", RealCustomerBundle.BIRTHDAY_INVALID_FORMAT);
            }
        }
        return errors;
    }

    private static MessageBundle validateNationalCode(String nationalCode) {
        MessageBundle errors = new MessageBundle();
        if (nationalCode == null || "".equalsIgnoreCase(nationalCode)) {
            errors.addError("nationalCode", RealCustomerBundle.NATIONAL_CODE_REQUIRED);
        } else if (RealCustomerManager.findByNationalCode(nationalCode).size() != 0) {
            errors.addError("nationalCode", RealCustomerBundle.NATIONAL_CODE_IS_UNIQUE);
        }
        return errors;
    }

    public static RealCustomerView findById(int id) throws NotFoundObjectException {
        RealCustomerManager realCustomerManager = new RealCustomerManager();
        RealCustomer realCustomer = realCustomerManager.findById(id);
        if (realCustomer != null) {
            return realCustomer.toView();
        }
        throw new NotFoundObjectException();
    }

    public static MessageBundle update(RealCustomerView view) {
        MessageBundle errors = new MessageBundle();
        errors.addAll(validate(view));
        if (errors.isValid()) {
            try {
                RealCustomerView realCustomerView = findById(view.id);
                RealCustomerManager realCustomerManager = new RealCustomerManager();
                view.customerNumber = realCustomerView.customerNumber;
                realCustomerManager.update(view.toModel());
            } catch (NotFoundObjectException e) {
                errors.addError("base", RealCustomerBundle.NOT_FOUNT_REAL_CUSTOMER);
            }
        }
        return errors;
    }

    public static MessageBundle delete(int id) {
        MessageBundle messageBundle = new MessageBundle();
        RealCustomerManager realCustomerManager = new RealCustomerManager();
        realCustomerManager.delete(id);
        return messageBundle;
    }

    public static List<RealCustomer> all(RealCustomerView realCustomerView) {
        RealCustomerManager realCustomerManager = new RealCustomerManager();

        return realCustomerManager.all(realCustomerView.toModel());

    }
}
