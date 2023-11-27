package com.ra.model.dao;

import java.util.List;

public interface IGenericDAO<T,ID> {
    List<T> fillAll();
    boolean saveOfUpdate(T t);
    T findById(ID id);
    void delete(ID id);

}
