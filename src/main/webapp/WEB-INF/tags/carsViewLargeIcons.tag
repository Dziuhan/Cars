<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<body>
	<fmt:setLocale value="${locale}" />
	<fmt:bundle
		basename="ua.dziuhan.utilities.ResourceBundle.Page"
		prefix="tableCars.">
		<c:forEach items="${pageList}" var="car">
			<div class="Large">
				<div>
					<img alt=" No foto"
						src="${pageContext.request.contextPath}/picture/s_picture/${car.imageLocAdress}">
				</div>
				<div>${car.producer}${car.make}</div>
				<div>
					<fmt:message key="Year" />
					${car.year}
					<fmt:message key="Rank" />
					${car.rank}
				</div>
				<div>
					<fmt:message key="Price" />
					${car.price}
				</div>
				<form action="car${car.id}" class="center">
					<a href="ReviewsCar_Id=${car.id}"><fmt:message key="Reviews" /></a>
					<input type="submit" value="<fmt:message key="Choose"/>">
				</form>
			</div>
		</c:forEach>
		<c:if test="${empty pageList}">
			<b class="center"><fmt:message key="NotFoundCars" /></b>
		</c:if>
	</fmt:bundle>
</html>