<%@ include file="navbar.jsp" %>

<h3>Add New Employee</h3>

<form action="EmployeeController?action=insert" method="post" class="w-50">

  <label>Name</label>
  <input type="text" name="name" class="form-control mb-2" required>

  <label>Username</label>
  <input type="text" name="username" class="form-control mb-2" required>

  <label>Password</label>
  <input type="password" name="password" class="form-control mb-2" required>

  <button type="submit" class="btn btn-success">Save</button>

</form>

<br>

<a href="EmployeeController?action=list">Back</a>