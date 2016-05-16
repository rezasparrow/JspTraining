package dataaccess;

import bean.RealCustomer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class RealCustomerManager extends Manager<RealCustomer> {

    public static List<RealCustomer> findByNationalCode(String nationalCode) {
            Session session = DataBaseManager.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(RealCustomer.class).add(Restrictions.eq("nationalCode", nationalCode));
            List<RealCustomer> entities = criteria.list();
            session.close();
            return entities;
        }

    @Override
    Class<RealCustomer> getEntityClass() {
        return RealCustomer.class;
    }

    @Override
    Criteria createFindQuery(Criteria criteria, RealCustomer entity) {
        if ((entity.getCustomerNumber() != null)) {
            criteria.add(Restrictions.eq("customerNumber", entity.getCustomerNumber()));
        }
        if (entity.getFirstName() != null && !"".equalsIgnoreCase(entity.getFirstName().trim())) {
            criteria.add(Restrictions.eq("firstName", entity.getFirstName()));
        }
        if (entity.getLastName() != null && !"".equalsIgnoreCase(entity.getLastName().trim())) {
            criteria.add(Restrictions.eq("lastName", entity.getLastName()));
        }
        if (entity.getNationalCode() != null && !"".equalsIgnoreCase(entity.getNationalCode().trim())) {
            criteria.add(Restrictions.eq("nationalCode", entity.getNationalCode()));
        }

        return criteria;
    }


}


