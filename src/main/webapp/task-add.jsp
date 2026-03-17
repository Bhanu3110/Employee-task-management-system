<%@ page import="java.util.*,com.dto.User" %>
<%@ include file="navbar.jsp" %>
<%
 List<User> employees = (List<User>) request.getAttribute("employees");
%>

<h3>Create Task</h3>

<form action="TaskController?action=insert" method="post" class="w-50">

  <label>Title</label>
  <input type="text" name="title" class="form-control mb-2" required>

  <label>Description</label>
  <textarea name="description" class="form-control mb-2"></textarea>

  <label>Assign To</label>
  <select name="assignedTo" class="form-control mb-2">
    <% for(User e : employees){ %>
      <option value="<%=e.getId()%>"><%=e.getName()%></option>
    <% } %>
  </select>

  <label>Status</label>
  <select name="status" class="form-control mb-2">
    <option value="Pending">Pending</option>
    <option value="In Progress">In Progress</option>
    <option value="Completed">Completed</option>
  </select>

  <label>Due Date</label>
  <input type="date" name="dueDate" class="form-control mb-2">

  <button class="btn btn-success">Save</button>
</form>
