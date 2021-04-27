<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
<h1>Login here</h1>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action="/login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="text"  placeholder="Enter username" name="username"> 
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password"  placeholder="Password" name="password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>