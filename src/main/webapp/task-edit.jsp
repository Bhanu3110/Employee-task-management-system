<%@ page import="java.util.*,com.dto.Task,com.dto.User" %>
<%@ include file="navbar.jsp" %>
<%
 Task t = (Task) request.getAttribute("task");
 List<User> employees = (List<User>) request.getAttribute("employees");
%>

<h3>Edit Task</h3>

<form action="TaskController?action=update" method="post" class="w-50">
<input type="hidden" name="id" value="<%=t.getId()%>">

<label>Title</label>
<input type="text" name="title" value="<%=t.getTitle()%>" class="form-control mb-2">

<label>Description</label>
<textarea name="description" class="form-control mb-2"><%=t.getDescription()%></textarea>

<label>Assign To</label>
<select name="assignedTo" class="form-control mb-2">
  <% for(User e : employees){ %>
    <option value="<%=e.getId()%>" <%= (t.getAssignedTo()==e.getId()?"selected":"") %> >
      <%=e.getName()%>
    </option>
  <% } %>
</select>

<label>Status</label>
<select name="status" class="form-control mb-2">
  <option <%=t.getStatus().equals("Pending")?"selected":""%>>Pending</option>
  <option <%=t.getStatus().equals("In Progress")?"selected":""%>>In Progress</option>
  <option <%=t.getStatus().equals("Completed")?"selected":""%>>Completed</option>
</select>

<label>Due Date</label>
<input type="date" name="dueDate" value="<%=t.getDueDate()%>" class="form-control mb-2">

<button class="btn btn-success">Update</button>
</form>
