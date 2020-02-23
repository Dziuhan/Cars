<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags/"%>

<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="${locale}" />
	<fmt:bundle
		basename="ua.dziuhan.utilities.ResourceBundle.Page"
		prefix="admin.">
		<table>
			<tr>
				<td id="tableCars">
					<table>
						<tr>
							<th><fmt:message key="Producer" /></th>
							<th><fmt:message key="Make" /></th>
							<th><fmt:message key="Rank" /></th>
							<th><fmt:message key="Year" /></th>
							<th><fmt:message key="Price" /></th>
						</tr>
						<c:forEach items="${cars}" var="car">
							<tr>
								<td><a
									href="edit car idCar=${car.id} ">
										${car.producer} </a></td>
								<td>${car.make}</td>
								<td>${car.rank}</td>
								<td>${car.year}</td>
								<td>${car.price}</td>
								<td><a	href="edit car idCar=${car.id} ">
										<fmt:message key="Edit" />
								</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</fmt:bundle>
</body>
</html>