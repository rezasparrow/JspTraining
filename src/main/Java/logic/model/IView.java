package logic.model;

import bean.IEntity;

/**
 * Created by Dotin School1 on 5/12/2016.
 */
public interface IView <E extends IEntity>{
    E toModel();
    boolean isValid();
}
