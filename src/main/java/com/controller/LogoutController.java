package com.controller;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     req.getSession().invalidate();
     resp.sendRedirect("login.jsp");
 }
}
