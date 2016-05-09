package dataaccess;


import bean.Customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface CRUD<T extends Customer> {
    T create(T customer)  ;
    void delete(int id) ;
    List<T> all(T customer) ;
    List<T> all() ;
    List<T> findById(int id) ;
    List<T> update(int id, T customer)  ;
}
