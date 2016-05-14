package logic;

import bean.LoanType;
import logic.Bundle.LoanTypeBundle;
import dataaccess.LoanTypeManager;
import presentation.LoanTypeView;
import util.MessageBundle;

/**
 * Created by Dotin School1 on 5/12/2016.
 */
public class LoanTypeManipulator extends Manipulator<LoanTypeView, LoanType> {
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
