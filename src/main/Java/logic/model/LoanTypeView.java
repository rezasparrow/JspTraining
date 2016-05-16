package logic.model;

import bean.GrantCondition;
import bean.LoanType;
import org.hibernate.type.LongType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoanTypeView implements Serializable, IView<LoanType> {
    private Integer id;
    private String name;
    private Float rate;
    private List<GrantConditionView> grantConditions = new ArrayList<>();

    public LoanTypeView() {
    }

    public LoanTypeView(String name, Float rate) {
        this.name = name;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRate() {
        return rate == null ? 0.0F : rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public LoanType toModel() {
        LoanType loanType = new LoanType();
        if (id != null) {
            loanType.setId(id);
        }
        loanType.setName(name);
        if (rate != null) {
            loanType.setRate(rate);
        }
        Set<GrantCondition> grants = new HashSet<>();
        for (GrantConditionView grand : grantConditions) {
            grants.add(grand.toModel());
        }
        loanType.setGrantConditions(grants);
        return loanType;
    }

    @Override
    public boolean isValid() {
        if (name == null && "".equals(name.trim())) {
            return false;
        }
        if (name == null && "".equals(name.trim())) {
            return false;
        }
        for (GrantConditionView condition : grantConditions) {
            if (!condition.isValid()) {
                return false;
            }
        }
        return true;
    }

    public List<GrantConditionView> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(List<GrantConditionView> grantConditions) {
        this.grantConditions = grantConditions;
    }

    public void addGrantCondition(GrantConditionView grantCondition) {
        grantConditions.add(grantCondition);
    }

    public static LoanTypeView toView(LoanType loanType){
        LoanTypeView loanTypeView = new LoanTypeView();
        loanTypeView.id = loanType.getId();
        loanTypeView.name = loanType.getName();
        loanTypeView.rate = loanType.getRate();
        return loanTypeView;
    }

}
