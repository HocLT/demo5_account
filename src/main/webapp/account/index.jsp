<%@page import="vn.aptech.entity.Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account List</title>
</head>
<body>
	<h1>Account List</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Email</th>
				<th>Phone</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
			if (request.getAttribute("accounts") != null) {
				List<Account> accounts = (List<Account>) request.getAttribute("accounts");
				for (Account a : accounts) {
			%>
			<tr>
				<td><%=a.getId()%></td>
				<td><%=a.getEmail()%></td>
				<td><%=a.getPhone()%></td>
				<td><a href="Controller?a=DisplayUpdate&id=<%= a.getId() %>">Update</a></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>