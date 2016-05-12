package presentation;

import dataaccess.IEntity;

/**
 * Created by Dotin School1 on 5/12/2016.
 */
public interface IView <T extends IEntity>{
    T toModel();
}
