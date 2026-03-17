<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<style>
body{
    font-family: Arial;
    background:#f2f2f2;
}

.container{
    width:350px;
    margin:80px auto;
    padding:20px;
    background:white;
    border-radius:8px;
    box-shadow:0px 0px 10px #ccc;
}

h2{
    text-align:center;
}

input,select{
    width:100%;
    padding:8px;
    margin-top:5px;
    margin-bottom:15px;
}

button{
    width:100%;
    padding:10px;
    background:#007BFF;
    color:white;
    border:none;
    border-radius:4px;
}

button:hover{
    background:#0056b3;
}

a{
    text-decoration:none;
}
</style>

</head>
<body>

<div class="container">

<h2>Register</h2>

<form action="<%=request.getContextPath()%>/RegisterController" method="post">

<label>Name</label> <input type="text" name="name" required>

<label>Username</label> <input type="text" name="username" required>

<label>Password</label> <input type="password" name="password" required>

<label>Role</label> <select name="role">

<option value="EMPLOYEE">Employee</option>
<option value="ADMIN">Admin</option>
</select>

<button type="submit">Register</button>

</form>

<br>

<p style="text-align:center;">
Already have an account?  
<a href="login.jsp">Login</a>
</p>

</div>

</body>
</html>
