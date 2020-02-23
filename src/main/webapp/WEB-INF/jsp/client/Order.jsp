<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car order</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="style/all.css" />
</head>
<body>
	<%@ include file="/WEB-INF/jspf/headerMenu.jspf"%>
	<fmt:setLocale value="${locale}" />
	<fmt:bundle
		basename="ua.dziuhan.utilities.ResourceBundle.Page"
		prefix="orderClient.">


		<div
			style="background: url('${pageContext.request.contextPath}/picture/l_picture/${chooseCar.imageLocAdress}') no-repeat 100%;background-size: 100%;width:avto; height: 100%;">
			<div id="order">
				<form action="make_order" name="order">
					<div>${chooseCar.producer}${chooseCar.make}</div>
					<div>
						<fmt:message key="Rank" />
						: ${chooseCar.rank}
					</div>
					<div>
						<fmt:message key="Price1Day" />
						: ${chooseCar.price}
					</div>

					<fmt:message key="From" />
					<input type="date" name="startRent" min="${currentDate}"
						required="required" value="${currentDate}">
					<fmt:message key="Before" />
					<input type="date" name="finishRent" min="${currentDate}"
						required="required">

					<div>
						<input	type="hidden" name="idCar" value="${chooseCar.id}">
						<input	type="submit" value="<fmt:message key="Order"/>">
					</div>
					<span> ${messeageForClient}</span>
				</form>
			</div>
		</div>
	</fmt:bundle>
</body>
</html>