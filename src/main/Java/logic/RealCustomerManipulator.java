package logic;


import bean.RealCustomer;
import logic.Bundle.RealCustomerBundle;
import dataaccess.RealCustomerManager;
import exception.NotFoundObjectException;
import presentation.RealCustomerView;
import util.MessageBundle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RealCustomerManipulator extends Manipulator<RealCustomerView, RealCustomer> {


    @Override
    RealCustomerManager getManager() {
        return new RealCustomerManager();
    }

    MessageBundle validate(RealCustomerView realCustomerView) {
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
        if (realCustomerView.id == null) {
            errors.addAll(validateNationalCode(realCustomerView.nationalCode));
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

    @Override
    public MessageBundle update(RealCustomerView view) {
        MessageBundle messageBundle = new MessageBundle();
        try {
            RealCustomer entity = (RealCustomer) findById(view.id);
            view.customerNumber = entity.getCustomerNumber().toString();
            return super.update(view);
        } catch (NotFoundObjectException e) {
            messageBundle.addError("base", "مشتری مورد نظر پیدا نشد.");
        }
        return messageBundle;
    }
}
