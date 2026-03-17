package com.controller;
import java.io.IOException;
import java.util.*;
import com.dao.TaskDAO;
import com.dao.UserDAO;
import com.dto.Task;
import com.dto.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
    
    /**
	 * 
	 */
	TaskDAO dao = new TaskDAO();
    UserDAO udao = new UserDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if("insert".equals(action)){

            Task t = new Task();

            t.setTitle(req.getParameter("title"));
            t.setDescription(req.getParameter("description"));
            t.setAssignedTo(Integer.parseInt(req.getParameter("assignedTo")));
            t.setStatus(req.getParameter("status"));
            t.setDueDate(req.getParameter("dueDate"));

            dao.save(t);

            resp.sendRedirect("TaskController?action=list");
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "list";

        try{
            switch(action){
                case "add":
                    req.setAttribute("employees", udao.getAllEmployees());
                    req.getRequestDispatcher("task-add.jsp").forward(req, resp);
                    break;
                case "insert":
                    Task t = new Task();
                    t.setTitle(req.getParameter("title"));
                    t.setDescription(req.getParameter("description"));
                    t.setAssignedTo(Integer.parseInt(req.getParameter("assignedTo")));
                    t.setStatus(req.getParameter("status"));
                    t.setDueDate(req.getParameter("dueDate"));
                    dao.save(t);
                    resp.sendRedirect("TaskController?action=list");
                    break;
                case "edit":
                    Task task = dao.getById(Integer.parseInt(req.getParameter("id")));
                    req.setAttribute("task", task);
                    req.setAttribute("employees", udao.getAllEmployees());
                    req.getRequestDispatcher("task-edit.jsp").forward(req, resp);
                    break;
                case "update":
                    Task tt = new Task();
                    tt.setId(Integer.parseInt(req.getParameter("id")));
                    tt.setTitle(req.getParameter("title"));
                    tt.setDescription(req.getParameter("description"));
                    tt.setAssignedTo(Integer.parseInt(req.getParameter("assignedTo")));
                    tt.setStatus(req.getParameter("status"));
                    tt.setDueDate(req.getParameter("dueDate"));
                    dao.update(tt);
                    resp.sendRedirect("TaskController?action=list");
                    break;
                case "delete":
                    dao.delete(Integer.parseInt(req.getParameter("id")));
                    resp.sendRedirect("TaskController?action=list");
                    break;
                default:  
                    req.setAttribute("list", dao.getAll());
                    req.getRequestDispatcher("task-list.jsp").forward(req, resp);
            }
        }catch(Exception e){ e.printStackTrace(); }
    }
}
