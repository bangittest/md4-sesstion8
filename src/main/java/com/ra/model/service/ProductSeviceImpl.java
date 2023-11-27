package com.ra.model.service;

import com.ra.model.dao.ProductDAO;
import com.ra.model.dao.ProductDAOImpl;
import com.ra.model.entity.Product;

import java.util.List;

public class ProductSeviceImpl implements ProductService{
    private final ProductDAO productDAO=new ProductDAOImpl();

    @Override
    public List<Product> fillAll() {
        return productDAO.fillAll();
    }

    @Override
    public boolean saveOfUpdate(Product product) {
        return productDAO.saveOfUpdate(product);
    }

    @Override
    public Product findById(Integer integer) {
        return productDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        productDAO.delete(integer);
    }
}
