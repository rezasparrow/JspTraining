package dataaccess;

import bean.GrantCondition;
import bean.LoanFile;
import bean.LoanType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    @Override
    public void create(LoanType loanType) {
        try (DataBaseManager dataBaseManager = new DataBaseManager()) {
            Session session = dataBaseManager.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(loanType);
            for (GrantCondition grantCondition:loanType.getGrantConditions()){
                grantCondition.setLoanType(loanType);
                session.persist(grantCondition);
            }
            transaction.commit();
            session.close();
        }
    }
}
