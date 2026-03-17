package com.controller;
import java.io.IOException;
import com.dao.TaskDAO;
import com.dto.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/EmployeeTasksController")
public class EmployeeTasksController extends HttpServlet {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 TaskDAO dao = new TaskDAO();

 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     User u = (User) req.getSession().getAttribute("user");
     req.setAttribute("tasks", dao.getTasksForEmployee(u.getId()));
     req.getRequestDispatcher("employee-tasks.jsp").forward(req, resp);
 }

 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     int id = Integer.parseInt(req.getParameter("id"));
     String status = req.getParameter("status");
     dao.updateStatus(id, status);
     resp.sendRedirect("EmployeeTasksController");
 }
}
