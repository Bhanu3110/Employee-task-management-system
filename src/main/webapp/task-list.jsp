<%@ page import="java.util.*,com.dto.Task" %>
<%@ include file="navbar.jsp" %>
<%
 List<Task> list = (List<Task>) request.getAttribute("list");
%>

<div class="d-flex justify-content-between">
 <h3>Tasks</h3>
 <a class="btn btn-primary" href="TaskController?action=add">Create Task</a>
</div>

<table class="table table-bordered mt-3">
<tr>
 <th>ID</th><th>Title</th><th>Assigned To</th><th>Status</th><th>Due</th><th>Actions</th>
</tr>
<% for(Task t : list){ %>
<tr>
 <td><%=t.getId()%></td>
 <td><%=t.getTitle()%></td>
 <td><%=t.getAssignedTo()%></td>
 <td><%=t.getStatus()%></td>
 <td><%=t.getDueDate()%></td>
 <td>
   <a class="btn btn-warning btn-sm" href="TaskController?action=edit&id=<%=t.getId()%>">Edit</a>
   <a class="btn btn-danger btn-sm" href="TaskController?action=delete&id=<%=t.getId()%>">Delete</a>
 </td>
</tr>
<% } %>
</table>
