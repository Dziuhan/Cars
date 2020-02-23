<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
</head>
<body>

	<table>
		<tr>
			<th>Id</th>
			<th>Login</th>
			<th>Role</th>
			<th>Ban</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td><a
					href="edit user login=${user.login}">
						${user.login}</a></td>
				<td>${user.role.role}</td>
				<td>${user.ban}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>