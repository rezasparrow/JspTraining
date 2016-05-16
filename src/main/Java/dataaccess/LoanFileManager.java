package dataaccess;

import bean.LoanFile;
import org.hibernate.Criteria;

/**
 * Created by Dotin School1 on 5/16/2016.
 */
public class LoanFileManager extends  Manager<LoanFile> {
    @Override
    Class<LoanFile> getEntityClass() {
        return LoanFile.class;
    }

    @Override
    Criteria createFindQuery(Criteria criteria, LoanFile entity) {
        return criteria;
    }
}
