package logic;

import bean.LoanFile;
import bean.LoanType;
import bean.RealCustomer;
import dataaccess.LoanFileManager;
import dataaccess.Manager;
import exception.NotFoundObjectException;
import logic.bundle.LoanFileBundle;
import logic.model.LoanFileView;
import logic.model.LoanTypeView;
import logic.model.RealCustomerView;
import org.hibernate.type.LongType;
import util.MessageBundle;

public class LoanFileManipulator extends Manipulator<LoanFileView, LoanFile> {
    private final RealCustomerManipulator realCustomerManipulator;
    private final LoanTypeManipulator loanTypeManipulator;

    public LoanFileManipulator() {
        realCustomerManipulator = new RealCustomerManipulator();
        loanTypeManipulator = new LoanTypeManipulator();
    }

    @Override
    Manager<LoanFile> getManager() {
        return new LoanFileManager();
    }

    @Override
    MessageBundle validate(LoanFileView view) {
        return new MessageBundle();
    }

    @Override
    public MessageBundle save(LoanFileView view) {
        Integer customerId = view.getRealCustomer().getId();
        Integer loanTypeId = view.getLoanType().getId();
        MessageBundle messages = new MessageBundle();
        try {
            view.setLoanType(LoanTypeView.toView(loanTypeManipulator.findById(loanTypeId)));

        } catch (NotFoundObjectException e) {
            messages.addError("loanType", LoanFileBundle.CAN_NOT_FOUNT_LOAN_FILE);
        }
        try {
            view.setRealCustomer(RealCustomerView.toView(realCustomerManipulator.findById(customerId)));
        } catch (NotFoundObjectException e) {
            messages.addError("customer", LoanFileBundle.CAN_NOT_FOUNT_CUSTOMER);
        }
        if (messages.isValid()) {
            getManager().create(view.toModel());
        }
        return messages;
    }
}
