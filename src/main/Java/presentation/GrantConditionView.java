package presentation;

import bean.GrantCondition;
import com.sun.xml.internal.bind.v2.model.core.ReferencePropertyInfo;

import java.io.Serializable;


public class GrantConditionView implements Serializable,IView<GrantCondition> {
    private Integer id;

    private String name;
    private Integer maxAmount;
    private Integer minAmount;
    private Integer maxDuration;
    private Integer minDuration;

    public GrantConditionView() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GrantConditionView(String name, Integer maxAmount, Integer minAmount, Integer maxDuration, Integer minDuration) {
        this.name = name;
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.maxDuration = maxDuration;
        this.minDuration = minDuration;
    }

    public GrantConditionView(Integer id, String name, Integer maxAmount, Integer minAmount, Integer maxDuration, Integer minDuration) {
        this.id = id;
        this.name = name;
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.maxDuration = maxDuration;
        this.minDuration = minDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Integer getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    @Override
    public GrantCondition toModel() {
        return null;
    }

}
