<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Admin Changer</title>
</head>
<body>
	<c:choose>
		<c:when test="${userForEditAdmin.ban==true}">
			<c:set value="checked" var="check" />
		</c:when>
		<c:when test=" ${userForEditAdmin.ban==false}">
			<c:set value="" var="check" />
		</c:when>
	</c:choose>

		<table>
			<tr>
				<th>Id</th>
				<th>Login</th>
				<th>Role</th>
				<th>Ban</th>
			</tr>
			<form action="saveUser" name="editedUser">
			<tr>
				<td> ${userForEditAdmin.id} </td>
				<td><input name="login" hidden="hidden" value="${userForEditAdmin.login}"/> ${userForEditAdmin.login}</td>
				<td><select name="role.role">
						<option>${userForEditAdmin.role.role}</option>
						<optgroup label="Change role"></optgroup>
						<option value="client">client</option>
						<option value="manager">manager</option>
						<option value="admin">admin</option>
				</select></td>
				<td><input type="checkbox" name="ban" ${check}></td>
				<td> <input type="submit" value="Save user"></td>
			</tr>
			</form>
		</table>
</body>
</html>