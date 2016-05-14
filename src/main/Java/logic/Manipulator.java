package logic;

import bean.IEntity;
import dataaccess.Manager;
import exception.NotFoundObjectException;
import presentation.IView;
import util.MessageBundle;

import java.util.List;

public abstract class Manipulator<T extends IView,E extends IEntity > {
    private Manager manager;

    abstract Manager<E> getManager();

    abstract MessageBundle validate(T view);

    public Manipulator() {
        manager = getManager();
    }

    public List<E> all() {
        return manager.all();
    }

    public List<E> all(T view) {
        return manager.all(view.toModel());
    }

    public MessageBundle save(T view) {
        MessageBundle errors = validate(view);
        if (errors.isValid()) {
            manager.create(view.toModel());
        }
        return errors;
    }

    public IEntity findById(int id) throws NotFoundObjectException {
        IEntity entity = manager.findById(id);
        if (entity != null) {
            return entity;
        }
        throw new NotFoundObjectException();
    }

    public MessageBundle update(T view) {
        MessageBundle errors = new MessageBundle();
        errors.addAll(validate(view));
        if (errors.isValid()) {
            manager.update(view.toModel());
        }
        return errors;
    }

    public MessageBundle delete(int id) {
        MessageBundle messageBundle = new MessageBundle();
        manager.delete(id);
        return messageBundle;
    }


}
