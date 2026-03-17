package com.controller;

import java.io.IOException;

import com.dao.UserDAO;
import com.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {

private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String name = req.getParameter("name");
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String role = req.getParameter("role");

    User u = new User();
    u.setName(name);
    u.setUsername(username);
    u.setPassword(password);
    u.setRole(role);

    UserDAO dao = new UserDAO();
    int result = dao.save(u);

    if(result > 0){
        resp.sendRedirect("login.jsp");
    }else{
        resp.getWriter().println("Registration Failed!");
    }
}


}
