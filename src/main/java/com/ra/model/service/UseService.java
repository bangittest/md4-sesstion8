package com.ra.model.service;

import com.ra.model.dao.IGenericDAO;
import com.ra.model.entity.User;

import java.util.List;

public interface UseService extends IGenericDAO<User,Integer> {
    List<User> findByName(String name);
}
