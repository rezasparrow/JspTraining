package logic.model;

import bean.GrantCondition;

import java.io.Serializable;


public class GrantConditionView implements Serializable, IView<GrantCondition> {
    private Integer id;

    private String name;
    private Integer maxAmount;
    private Integer minAmount;
    private Integer maxDuration;
    private Integer minDuration;

    public GrantConditionView() {

    }

    public GrantConditionView(String name, String maxAmount, String minAmount, String maxDuration, String minDuration) {
        this.name = name;

        try {
            this.maxAmount = Integer.parseInt(maxAmount);
        } catch (Exception e) {
            this.maxAmount = null;
        }

        try {
            this.minAmount = Integer.parseInt(minAmount);
        } catch (Exception e) {
            this.minAmount = null;
        }
        try {
            this.maxDuration = Integer.parseInt(maxDuration);
        } catch (Exception e) {
            this.maxDuration = null;
        }


        try {
            this.minDuration = Integer.parseInt(minDuration);
        } catch (Exception e) {
            this.minDuration = null;
        }
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
        GrantCondition grantCondition = new GrantCondition();
        if (isValid()) {
            if (id != null) {
                grantCondition.setId(id);
            }
            grantCondition.setName(name);
            grantCondition.setMaxAmount(maxAmount);
            grantCondition.setMinAmount(minAmount);
            grantCondition.setMaxDuration(maxDuration);
            grantCondition.setMinDuration(minDuration);
            return grantCondition;

        } else {
            return null;
        }
    }

    public boolean isValid() {
        if (minAmount == null || "".equals(minAmount)) {
            return false;
        }
        if (minDuration == null || "".equals(minDuration)) {
            return false;
        }
        if (name == null || "".equals(name)) {
            return false;
        }
        if (maxAmount == null || "".equals(maxAmount)) {
            return false;
        }
        if (maxDuration == null || "".equals(maxDuration)) {
            return false;
        }
        return true;
    }
}
