package controller;

import bean.LoanType;
import controller.Bundle.LoanTypeBundle;
import controller.Bundle.RealCustomerBundle;
import dataaccess.LoanTypeManager;
import dataaccess.Manager;
import presentation.LoanTypeView;
import util.MessageBundle;

import javax.swing.text.View;

/**
 * Created by Dotin School1 on 5/12/2016.
 */
public class LoanTypeController extends Controller<LoanTypeView, LoanType> {
    @Override
    LoanTypeManager getManager() {
        return new LoanTypeManager();
    }

    @Override
    MessageBundle validate(LoanTypeView view) {
        MessageBundle errors = new MessageBundle();
        if (view.getName() == null || view.getName().trim().length() == 0) {
            errors.addError("lastName", LoanTypeBundle.NAME_REQUIRED);
        }
        if (view.getRate() == null || view.getName().trim().length() == 0) {
            errors.addError("lastName", LoanTypeBundle.RATE_REQUIRED);
        }
        if (view.getGrantConditions().size() == 0){
            errors.addError("grantCondition", LoanTypeBundle.GRANT_CONDITION_REQUIRED);
        }
        return errors;
    }
}
