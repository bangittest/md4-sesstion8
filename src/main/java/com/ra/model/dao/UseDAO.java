package com.ra.model.dao;

import com.ra.model.entity.User;

import java.util.List;

public interface UseDAO extends IGenericDAO<User,Integer>{
    List<User> findByName(String name);
}
