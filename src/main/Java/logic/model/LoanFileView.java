package logic.model;

import bean.LoanFile;
import bean.LoanType;
import bean.RealCustomer;
import org.hibernate.type.LongType;

/**
 * Created by Dotin School1 on 5/16/2016.
 */
public class LoanFileView implements IView<LoanFile> {
    private Integer Id;

    private RealCustomerView realCustomer;
    private LoanTypeView loanType;

    @Override
    public LoanFile toModel() {
        LoanFile loanFile = new LoanFile();
        loanFile.setCustomer(realCustomer.toModel());
        loanFile.setLoanType(loanType.toModel());
        return loanFile;
    }

    @Override
    public boolean isValid() {
        if (realCustomer == null) {
            return false;
        }
        if (loanType == null) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public RealCustomerView getRealCustomer() {
        return realCustomer;
    }

    public void setRealCustomer(RealCustomerView realCustomer) {
        this.realCustomer = realCustomer;
    }

    public LoanTypeView getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanTypeView loanType) {
        this.loanType = loanType;
    }
}
