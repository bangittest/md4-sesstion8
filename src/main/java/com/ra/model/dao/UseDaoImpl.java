package com.ra.model.dao;

import com.ra.model.entity.User;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UseDaoImpl implements UseDAO{
    @Override
    public List<User> fillAll() {
        Connection connection=null;
        List<User>users=new ArrayList<>();
        try {
            connection= ConnectionDB.openConnection();
            PreparedStatement pstm=connection.prepareStatement("SELECT *FROM users");
            ResultSet resultSet=pstm.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
                users.add(user);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return users;
    }

    @Override
    public boolean saveOfUpdate(User user) {
        Connection connection=null;
        try {
           connection=ConnectionDB.openConnection();
           int check;
           if (user.getId()==0){
               String sql="INSERT INTO users(name,email,address)values(?,?,?)";
               PreparedStatement pstm=connection.prepareStatement(sql);
               pstm.setString(1,user.getName());
               pstm.setString(2,user.getEmail());
               pstm.setString(3,user.getAddress());
               check= pstm.executeUpdate();
           }else {
               String sql="update users set name=?,email=?,address=? where id=?";
               PreparedStatement pstm=connection.prepareStatement(sql);
               pstm.setString(1,user.getName());
               pstm.setString(2,user.getEmail());
               pstm.setString(3,user.getAddress());
               pstm.setInt(4,user.getId());
               check= pstm.executeUpdate();
           }
           if (check>0){
               return true;
           }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public User findById(Integer integer) {
        for (User user :fillAll()) {
            if (user.getId()==integer){
                return user;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Connection connection=null;
        try {
            connection=ConnectionDB.openConnection();
            String sql="DELETE FROM users WHERE id=?";
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setInt(1,id);
            int check=statement.executeUpdate();
            if (check==0){
                System.out.println("product id" +id +"k ton tai");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public List<User> findByName(String name) {
        List<User>userSeach=new ArrayList<>();
        for (User user :fillAll()) {
            if (user.getName().toLowerCase().contains(name.toLowerCase().trim())){
                userSeach.add(user);
            }
        }
        return userSeach;
    }
}
