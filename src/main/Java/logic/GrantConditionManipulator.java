package logic;

import bean.GrantCondition;
import logic.bundle.GrantConditionBundle;
import dataaccess.GrantConditionManager;
import dataaccess.Manager;
import logic.model.GrantConditionView;
import util.MessageBundle;



public class GrantConditionManipulator extends Manipulator<GrantConditionView, GrantCondition> {
    @Override
    Manager getManager() {
        return new GrantConditionManager();
    }

    @Override
    MessageBundle validate(GrantConditionView view) {
        MessageBundle messageBundle = new MessageBundle();
        if (view.getName() == null || "".equals(view.getName().trim())) {
            messageBundle.addError("name", GrantConditionBundle.NAME_REQUIRED);
        }

        if (view.getMaxAmount() == null) {
            messageBundle.addError("maxAmount", GrantConditionBundle.MAX_AMOUNT_REQUIRED);
        }
        if (view.getMinAmount() == null) {
            messageBundle.addError("minAmount", GrantConditionBundle.MIN_AMOUNT_REQUIRED);
        }
        if (view.getMaxDuration() == null) {
            messageBundle.addError("maxDuration", GrantConditionBundle.MAX_DURATION_REQUIRED);
        }
        if (view.getMinDuration() == null) {
            messageBundle.addError("minDuration", GrantConditionBundle.MIN_DURATION_REQUIRED);
        }

        if (view.getMaxAmount() != null && view.getMinAmount() != null && view.getMinAmount() >= view.getMaxAmount()) {
            messageBundle.addError("maxAmount", GrantConditionBundle.MAX_AMOUNT_GRATER_THAN_MAX_AMOUNT);
        }
        if (view.getMaxDuration() != null && view.getMinDuration() != null && view.getMinDuration() >= view.getMaxDuration()) {
            messageBundle.addError("maxDuration", GrantConditionBundle.MAX_DURATION_GRATER_THAN_MAX_DURATION);
        }
        return messageBundle;
    }
}
