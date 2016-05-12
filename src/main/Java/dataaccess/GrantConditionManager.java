package dataaccess;

import bean.GrantCondition;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


public class GrantConditionManager extends Manager<GrantCondition> {
    @Override
    Class<GrantCondition> getEntityClass() {
        return GrantCondition.class;
    }

    @Override
    Criteria createFindQuery(Criteria criteria, GrantCondition entity) {
        if (entity.getName() != null && "".equals(entity.getName().trim())) {
            criteria.add(Restrictions.eq("name", entity.getName()));
        }
        return criteria;
    }
}
