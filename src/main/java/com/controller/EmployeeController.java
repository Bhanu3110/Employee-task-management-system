package com.controller;
import java.io.IOException;
import java.util.*;
import com.dao.UserDAO;
import com.dto.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDAO dao = new UserDAO();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    String action = req.getParameter("action");

	    if ("insert".equals(action)) {

	        User u = new User();

	        u.setName(req.getParameter("name"));
	        u.setUsername(req.getParameter("username"));
	        u.setPassword(req.getParameter("password"));
	        u.setRole("EMPLOYEE");

	        dao.save(u);

	        resp.sendRedirect("EmployeeController?action=list");
	    }
	}
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "list";

        try {
            switch(action){
                case "add": req.getRequestDispatcher("employee-add.jsp").forward(req, resp); break;
                case "insert":
                    User u = new User();
                    u.setName(req.getParameter("name"));
                    u.setUsername(req.getParameter("username"));
                    u.setPassword(req.getParameter("password"));
                    u.setRole("EMPLOYEE");
                    dao.save(u);
                    resp.sendRedirect("EmployeeController?action=list");
                    break;
                case "delete":
                    dao.delete(Integer.parseInt(req.getParameter("id")));
                    resp.sendRedirect("EmployeeController?action=list");
                    break;
                default:
                    List<User> list = dao.getAllEmployees();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("employee-list.jsp").forward(req, resp);
            }
        } catch(Exception e){ e.printStackTrace(); }
    }
}
