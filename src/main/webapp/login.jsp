<form action="LoginController" method="post" class="p-4 w-50 m-auto border shadow">
  <h3 class="text-center">Login</h3>
  <input type="text" name="username" class="form-control mt-2" placeholder="Username" required>
  <input type="password" name="password" class="form-control mt-2" placeholder="Password" required>
  <button class="btn btn-primary w-100 mt-3">Login</button>
  <p class="text-danger text-center">${error}</p>
  Don't have an account?
<a href="register.jsp">Register</a>
</form>
