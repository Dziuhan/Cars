<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Admin</title>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/headerMenu.jspf"%>
	<fmt:bundle
		basename="ua.dziuhan.utilities.ResourceBundle.Page"
		prefix="admin.">
		<div class="center">

			<form action="viewNewCarAdmin" method="get" class="inline">
				 <input	type="submit" value="<fmt:message key="NewCar"/>">
			</form>

			<form action="viewAllCarsAdmin" method="get" class="inline">
				<input	type="submit" value="<fmt:message key="AllCars"/>">
			</form>

			<form action="viewSearchUserAdmin" name="searchUser" class="inline">
				<fmt:message key="SearchUser" />
				: <input type="text" name="login" value="">
			</form>

			<form action="viewAllUsersAdmin" class="inline">
				<input type="submit" value="<fmt:message key="AllUsers"/>">
			</form>

		</div>
		<hr>

		<c:choose>
			<c:when test="${viewAdmin=='new car'}">
				<jsp:include page="/WEB-INF/jspf/admin/newCarAdmin.jsp" />
			</c:when>
			<c:when test="${viewAdmin=='edit car'}">
				<jsp:include page="/WEB-INF/jspf/admin/editCarAdmin.jsp" />
			</c:when>
			<c:when test="${viewAdmin=='all cars'}">
				<jsp:include page="/WEB-INF/jspf/admin/allCarAdmin.jsp" />
			</c:when>
			<c:when test="${viewAdmin=='all users'}">
				<jsp:include page="/WEB-INF/jspf/admin/allUserAdmin.jsp" />
			</c:when>
			<c:when test="${viewAdmin=='search user'}">
				<jsp:include page="/WEB-INF/jspf/admin/allUserAdmin.jsp" />
			</c:when>
			<c:when test="${viewAdmin=='edit user'}">
				<jsp:include page="/WEB-INF/jspf/admin/editUserAdmin.jsp" />
			</c:when>

			<c:otherwise>
				<jsp:include page="/WEB-INF/jspf/admin/allCarAdmin.jsp" />
			</c:otherwise>

		</c:choose>
	</fmt:bundle>

</body>
</html>