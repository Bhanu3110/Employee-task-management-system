package com.controller;

import java.io.IOException;
import com.dao.UserDAO;
import com.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // DAO Call
        UserDAO dao = new UserDAO();
        User u = dao.login(username, password);

        if (u != null) { // login success
            HttpSession session = req.getSession();
            session.setAttribute("user", u);

            // Optional: Set session expiration 30 mins
            session.setMaxInactiveInterval(30 * 60);

            if ("ADMIN".equalsIgnoreCase(u.getRole())) {
                resp.sendRedirect("admin-dashboard.jsp");
            } else {
                resp.sendRedirect("EmployeeTasksController");  // Better redirect to controller
            }

        } else { // Login failed
            req.setAttribute("error", "Invalid username/password!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
