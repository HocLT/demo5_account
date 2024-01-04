<%@page import="vn.aptech.entity.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>
</head>
<body>
	<h1>Update Account</h1>
	<form action="${pageContext.request.contextPath}/Controller?a=Update" method="post">
		<%
		Account a = (Account)request.getAttribute("account");
		%>
		<input type="hidden" name="id" value="<%= a.getId() %>"/>
		<div>Email: <input name="email" value="<%= a.getEmail() %>"/></div>
		<div>Phone: <input name="phone" value="<%= a.getPhone() %>"/></div>
		<div>Role: 
			<select name="role">
				<option value="1" <%= a.getRole()== 1 ? "selected": "" %> >Admin</option>
				<option value="2" <%= a.getRole()== 2 ? "selected": "" %> >User</option>
			</select>
		</div>
		<div><input type="submit" value="Update"/></div>
	</form>
</body>
</html>