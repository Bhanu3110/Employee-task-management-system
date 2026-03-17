<%@ page import="java.util.*, com.dto.Task, com.dto.User" %>

<%@ include file="navbar.jsp" %>

<%
    User user = (User) session.getAttribute("user");
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>

<h3>My Tasks</h3>

<table class="table table-bordered mt-3">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Status</th>
        <th>Due</th>
        <th>Update</th>
    </tr>

    <% for (Task task : tasks) { %>
        <tr>
            <td><%= task.getId() %></td>
            <td><%= task.getTitle() %></td>
            <td><%= task.getDescription() %></td>
            <td><%= task.getStatus() %></td>
            <td><%= task.getDueDate() %></td>
            <td>
                <form action="EmployeeTasksController" method="post" class="d-flex">
                    <input type="hidden" name="id" value="<%= task.getId() %>">
                    <select name="status" class="form-select form-select-sm me-2">
                        <option <%= task.getStatus().equals("Pending") ? "selected" : "" %>>Pending</option>
                        <option <%= task.getStatus().equals("In Progress") ? "selected" : "" %>>In Progress</option>
                        <option <%= task.getStatus().equals("Completed") ? "selected" : "" %>>Completed</option>
                    </select>
                    <button class="btn btn-sm btn-primary">Save</button>
                </form>
            </td>
        </tr>
    <% } %>
</table>
