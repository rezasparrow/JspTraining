package dataaccess;

import bean.LoanFile;
import bean.LoanType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Dotin School1 on 5/12/2016.
 */
public class LoanTypeManager extends Manager<LoanType> {
    @Override
    Class<LoanType> getEntityClass() {
        return LoanType.class;
    }

    @Override
    Criteria createFindQuery(Criteria criteria, LoanType entity) {

        if (entity.getName() != null && !"".equalsIgnoreCase(entity.getName().trim())) {
            criteria.add(Restrictions.eq("name", entity.getName()));
        }

        return criteria;
    }
}
