<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cars order</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="style/all.css" />
</head>
<body>

	<fmt:setLocale value="${locale}" />
	<fmt:bundle
		basename="ua.dziuhan.utilities.ResourceBundle.Page"
		prefix="reviewsCar.">
		<%@ include file="/WEB-INF/jspf/headerMenu.jspf"%>
		<form action="car${idCar}" class="center">
			<input type="submit" value="<fmt:message key="Choose"/>">
		</form>

		<form action="addReviewAboutCar" method="post" class="center" name="reviewAboutCarData">
			<textarea cols="75" rows="8" maxlength="499" name="review"></textarea>
			<input type="hidden" name="idCar" value="${idCar}">
			<div>
				<input type="submit" value="<fmt:message key="SendReview"/>">
			</div>
		</form>


		<c:forEach items="${reviewsAboutCar}" var="Review">
			<div>
				<fieldset>
					<legend>${Review.userData.login} ${Review.dateReview} </legend>
					${Review.review}
				</fieldset>
			</div>
		</c:forEach>
	</fmt:bundle>
</body>
</html>