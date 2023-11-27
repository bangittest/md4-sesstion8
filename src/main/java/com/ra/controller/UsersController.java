package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.model.service.UseService;
import com.ra.model.service.UseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersController",value = "/users")
public class UsersController extends HttpServlet {
    private UseService useService=new UseServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                formAdd(req,resp);
                break;
            case "edit":
                formEdit(req,resp);
                break;
            case "delete":
                formDelete(req,resp);
                break;
            case "search":
                formSearch(req,resp);
                break;
            default:
                showUser(req,resp);
                break;
        }
    }

    private void formSearch(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String name=req.getParameter("search");
        List<User>listSearch=useService.findByName(name);
        req.setAttribute("users",listSearch);
        req.setAttribute("searchName",name);
        req.getRequestDispatcher("views/users/user.jsp").forward(req,resp);
    }

    private void formDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       int idDelete= Integer.parseInt(req.getParameter("id"));
       useService.findById(idDelete);
       useService.delete(idDelete);
       showUser(req,resp);
    }

    private void formEdit(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        int idEdit= Integer.parseInt(req.getParameter("id"));
        User user=useService.findById(idEdit);
        req.setAttribute("useList",user);
        req.getRequestDispatcher("views/users/edit-user.jsp").forward(req,resp);
    }

    private void formAdd(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.getRequestDispatcher("views/users/add-user.jsp").forward(req,resp);
    }

    private void showUser(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    List<User>userList =useService.fillAll();
    req.setAttribute("userList",userList);
    req.getRequestDispatcher("views/users/user.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "add":
                actionAddUser(req,resp);
                break;
                case "edit":
                    actionEditUser(req,resp);
                    break;
        }
    }

    private void actionEditUser(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
       int idEdit= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String address=(req.getParameter("address"));
        User user1=new User(idEdit,name,email,address);
        useService.saveOfUpdate(user1);
        showUser(req,resp);
    }

    private void actionAddUser(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        User user=new User();
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setAddress(req.getParameter("address"));
        useService.saveOfUpdate(user);
        showUser(req,resp);
    }
}
