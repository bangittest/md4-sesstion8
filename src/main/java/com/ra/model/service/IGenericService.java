package com.ra.model.service;

import java.util.List;

public interface IGenericService<T,ID> {
    List<T>fillAll();
    boolean saveOfUpdate(T t);
    T findById(ID id);
    void delete(ID id);
}
