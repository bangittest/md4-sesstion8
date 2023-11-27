package com.ra.model.dao;

import com.ra.model.entity.Product;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> fillAll() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT *FROM product");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setDescription(resultSet.getString("description"));
                product.setProducer(resultSet.getString("producer"));
                products.add(product);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return products;
    }

    @Override
    public boolean saveOfUpdate(Product product) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            int check;
            if (product.getId() == 0) {
                String sql = "INSERT INTO product(name,price,description,producer)values(?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setString(3, product.getDescription());
                statement.setString(4, product.getProducer());
                check = statement.executeUpdate();

            } else {
                String sql = "update product set name=?,price=?,description=?,producer=? where id=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setString(3, product.getDescription());
                statement.setString(4, product.getProducer());
                statement.setInt(5, product.getId());
                check = statement.executeUpdate();

            }
            if (check > 0) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        for (Product product : fillAll()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Connection connection=null;
        try {
            connection=ConnectionDB.openConnection();
            String sql="DELETE FROM product WHERE id=?";
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
}
