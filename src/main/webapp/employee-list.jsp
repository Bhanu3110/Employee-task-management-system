<%@ page import="java.util.*, com.dto.User" %>

<%@ include file="navbar.jsp" %>

<%
    List<User> list = (List<User>) request.getAttribute("list");
%>

<div class="d-flex justify-content-between align-items-center mt-3">
    <h3>Employees</h3>
    <a class="btn btn-primary" href="EmployeeController?action=add">Add Employee</a>
</div>

<table class="table table-bordered table-hover mt-3">
    <tr class="table-dark">
        <th>ID</th>
        <th>Name</th>
        <th>User name</th>
        <th>Action</th>
    </tr>

    <% for (User emp : list) { %>
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getName() %></td>
            <td><%= emp.getUsername() %></td>
            <td>
                <a class="btn btn-danger btn-sm"
                   href="EmployeeController?action=delete&id=<%= emp.getId() %>">
                   Delete
                </a>
            </td>
        </tr>
    <% } %>
</table>
