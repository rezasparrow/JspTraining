package presentation;

import bean.LoanType;
import org.hibernate.type.LongType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoanTypeView implements Serializable,IView<LoanType> {
    private String id;
    private String name;
    private String rate;
    private List<GrantConditionView> grantConditions = new ArrayList<>();

    public LoanTypeView() {
    }

    public LoanTypeView(String name, String rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate == null ? "0.0" : rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public LoanType toModel() {
        LoanType loanType = new LoanType();
        if(id!= null)
        {
            loanType.setId(Integer.parseInt(id));
        }
        loanType.setName(name);
        if(rate != null){
            loanType.setRate(Float.parseFloat(rate));
        }

        return loanType;
    }

    public List<GrantConditionView> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(List<GrantConditionView> grantConditions) {
        this.grantConditions = grantConditions;
    }

    public void addGrantCondition(GrantConditionView grantCondition){
        grantConditions.add(grantCondition);
    }
}
