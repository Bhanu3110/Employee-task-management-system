<%@ page import="com.dto.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"ADMIN".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<%@ include file="navbar.jsp" %>

<h2 class="mt-3">Welcome Admin: <%= user.getName() %></h2>
<hr>
<p>Use the navigation bar above to manage employees and tasks.</p>
