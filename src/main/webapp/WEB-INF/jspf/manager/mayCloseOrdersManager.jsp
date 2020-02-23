<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:setLocale value="${locale}" />
	<fmt:bundle
		basename="ua.dziuhan.utilities.ResourceBundle.Page"
		prefix="manager.">

		<c:choose>
			<c:when test="${empty orders}">
				<b>Not found new orders</b>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th><fmt:message key="Login" /></th>
						<th><fmt:message key="Car" /></th>
						<th><fmt:message key="Begin" /></th>
						<th><fmt:message key="End" /></th>
						<th><fmt:message key="Driver" /></th>
						<th><fmt:message key="PriceOrder" /></th>
						<th><fmt:message key="State" /></th>
					</tr>
					<c:forEach items="${orders}" var="order">
						<tr>
							<td>${order.userData.login}</td>
							<td>${order.carData.producer}${order.carData.make} ${order.carData.year}</td>
							<td>${order.startRent}</td>
							<td>${order.finishRent}</td>
							<td>${order.driver}</td>
							<td>${order.priceTotal}</td>
							<td>${order.state}</td>
							<td><form action="closeOrderById=${order.id}" >
									<input type="submit" value="Close">
								</form></td>
						</tr>
					</c:forEach>
				</table>

			</c:otherwise>
		</c:choose>
	</fmt:bundle>
</body>
</html>