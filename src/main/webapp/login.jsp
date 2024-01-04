<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="${pageContext.request.contextPath}/Controller?a=Login" method="post">
		<div>Email: <input name="email"/></div>
		<div>Password: <input type="password" name="password"/></div>
		<div><input type="submit" value="Login"/></div>
	</form>
</body>
</html>