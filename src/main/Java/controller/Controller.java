package controller;

import bean.RealCustomer;
import controller.Bundle.RealCustomerBundle;
import dataaccess.IEntity;
import dataaccess.Manager;
import dataaccess.RealCustomerManager;
import exception.NotFoundObjectException;
import presentation.IView;
import presentation.RealCustomerView;
import sun.misc.resources.Messages_es;
import util.MessageBundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Controller<T extends IView,E extends IEntity > {
    private Manager manager;

    abstract Manager<E> getManager();

    abstract MessageBundle validate(T view);

    public Controller() {
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
