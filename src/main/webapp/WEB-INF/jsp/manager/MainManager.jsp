<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager</title>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/headerMenu.jspf"%>

	<fmt:bundle
		basename="ua.dziuhan.utilities.ResourceBundle.Page"
		prefix="manager.">
		<div>
			<form action="order_state=new order" class="inline">
				<input type="hidden" name="commandManager" value="new orders">
				<input type="submit" value="<fmt:message key="NewOrders" />">
			</form>

			<form action="order_state=waiting for payment" class="inline">
				<input type="hidden" name="commandManager" value="waiting for payment">
				<input type="submit" value="<fmt:message key="WaitingForPayment" />">
			</form>

			<form action="order_state=paid order" class="inline">
				<input type="hidden" name="commandManager" value="paid orders">
				<input type="submit" value="<fmt:message key="PaidOrders"/>">
			</form>

			<form action="order_state=rejected order" class="inline">
				<input type="hidden" name="commandManager" value="rejected orders">
				<input type="submit" value="<fmt:message key="RejectedOrders"/>">
			</form>

			<form action="order_state=may close order" class="inline">
				<input type="submit" value=" 1 <fmt:message key="Mayclocse"/>">
			</form>

			<form action="order_state=closed order" class="inline">
				<input type="submit" value="<fmt:message key="ClosedOrders"/>">
			</form>

			<form action="order_state=all order" class="inline">
				<input type="submit" value="<fmt:message key="AllOrders"/>">
			</form>
		</div>
		<c:choose>
			<c:when test="${stateOrderByManager=='new order'}">
				<jsp:include page="/WEB-INF/jspf/manager/newOrdersManager.jsp" />
			</c:when>
			<c:when test="${stateOrderByManager=='waiting for payment'}">
				<jsp:include page="/WEB-INF/jspf/manager/waitingOrdersManager.jsp" />
			</c:when>
			<c:when test="${stateOrderByManager=='rejected order'}">
				<jsp:include page="/WEB-INF/jspf/manager/rejectedOrdersManager.jsp" />
			</c:when>
			<c:when test="${stateOrderByManager=='paid order'}">
				<jsp:include page="/WEB-INF/jspf/manager/paidOrdersManager.jsp" />
			</c:when>
			<c:when test="${stateOrderByManager=='may close order'}">
				<jsp:include page="/WEB-INF/jspf/manager/mayCloseOrdersManager.jsp" />
			</c:when>
			<c:when test="${stateOrderByManager=='closed order'}">
				<jsp:include page="/WEB-INF/jspf/manager/closedOrdersManager.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="/WEB-INF/jspf/manager/allOrdersManager.jsp" />
			</c:otherwise>
		</c:choose>

	</fmt:bundle>
</body>
</html>