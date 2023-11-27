package com.ra.controller;

import com.ra.model.entity.Product;
import com.ra.model.service.ProductService;
import com.ra.model.service.ProductSeviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", value = "/product")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductSeviceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                formAdd(req,resp);
                break;
            case "edit":
                formEdit(req,resp);
                break;
            case "delete":
                actionDelete(req,resp);
                break;
            default:
                showProduct(req,resp);
                break;
        }
    }

    private void formEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int idEdit= Integer.parseInt(req.getParameter("id"));
        Product pro=productService.findById(idEdit);
        req.setAttribute("pro",pro);
        req.getRequestDispatcher("views/edit-product.jsp").forward(req,resp);
    }

    private void formAdd(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.getRequestDispatcher("views/form-add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                actionFormAdd(req,resp);
                break;
            case "edit":
                actionFormEdit(req,resp);
                break;
//            case "delete":
//
//                break;
            default:
                showProduct(req,resp);
                break;
        }
    }

    private void actionDelete(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        int idEdit= Integer.parseInt(req.getParameter("id"));
        productService.findById(idEdit);
        productService.delete(idEdit);
        showProduct(req,resp);
    }

    private void actionFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int idEdit= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        double price= Double.parseDouble(req.getParameter("price"));
        String description=req.getParameter("description");
        String producer=req.getParameter("producer");
        Product productEdit=new Product(idEdit,name,price,description,producer);
        productService.saveOfUpdate(productEdit);
        showProduct(req,resp);

    }

    private void actionFormAdd(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Product product=new Product();
        product.setName(req.getParameter("name"));
        product.setPrice(Double.parseDouble(req.getParameter("price")));
        product.setDescription(req.getParameter("description"));
        product.setProducer(req.getParameter("producer"));
        productService.saveOfUpdate(product);
        showProduct(req,resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product>listProduct=productService.fillAll();
        req.setAttribute("listProduct",listProduct);
        req.getRequestDispatcher("views/product.jsp").forward(req,resp);
    }
}
