package com.ra.model.service;

import com.ra.model.dao.UseDAO;
import com.ra.model.dao.UseDaoImpl;
import com.ra.model.entity.User;

import java.util.List;

public class UseServiceImpl implements UseService{
    UseDAO useDAO=new UseDaoImpl();
    @Override
    public List<User> fillAll() {
        return useDAO.fillAll();
    }

    @Override
    public boolean saveOfUpdate(User user) {
        return useDAO.saveOfUpdate(user);
    }

    @Override
    public User findById(Integer integer) {
        return useDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        useDAO.delete(integer);
    }

    @Override
    public List<User> findByName(String name) {
        return useDAO.findByName(name);
    }
}
