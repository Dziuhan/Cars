<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Admin Changer</title>
</head>
<body>
	<fmt:setLocale value="${locale}" />
	<fmt:bundle
		basename="ua.dziuhan.utilities.ResourceBundle.Page"
		prefix="admin.">

		<form action="saveCar">
			<input type="hidden" name="id" value="${editCar.id}">

			<fieldset>
				<legend>
					<fmt:message key="Image" />
				</legend>
				<input name="imageLocAdress" value="${editCar.imageLocAdress}" />
			</fieldset>

			<fieldset>
				<legend>
					<fmt:message key="Producer" />
				</legend>
				<input name="producer" required="required"
					value="${editCar.producer}" />
			</fieldset>
			<fieldset>
				<legend>
					<fmt:message key="Make" />
				</legend>
				<input name=make required="required" value="${editCar.make}" />
			</fieldset>
			<fieldset>
				<legend>
					<fmt:message key="Rank" />
				</legend>
				<input name="rank" required="required" value="${editCar.rank}" />
			</fieldset>
			<fieldset>
				<legend>
					<fmt:message key="Year" />
				</legend>
				<input type="number" required="required" name="year"
					value="${editCar.year}" />
			</fieldset>
			<fieldset>
				<legend>
					<fmt:message key="Price" />
				</legend>
				<input name="price" required="required" value="${editCar.price}" />
			</fieldset>
			<input type="submit" value="<fmt:message key="SaveCar"/>">
		</form>
		<form action="remove car id=${editCar.id}">
			<input type="submit" value="<fmt:message key="DeleteCar"/>">
		</form>

	</fmt:bundle>
</body>
</html>