<%@ page import="com.dto.User" %>
<%
 User u = (User) session.getAttribute("user");
 if(u == null){
     response.sendRedirect("login.jsp");
     return;
 }
%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Task Manager</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">

        <% if(u.getRole().equals("ADMIN")){ %>
          <li class="nav-item"><a class="nav-link" href="admin-dashboard.jsp">Dashboard</a></li>
          <li class="nav-item"><a class="nav-link" href="EmployeeController?action=list">Employees</a></li>
          <li class="nav-item"><a class="nav-link" href="TaskController?action=list">Tasks</a></li>
        <% } else { %>
          <li class="nav-item"><a class="nav-link" href="EmployeeTasksController">My Tasks</a></li>
        <% } %>

        <li class="nav-item"><a class="nav-link text-danger" href="LogoutController">Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-4">
