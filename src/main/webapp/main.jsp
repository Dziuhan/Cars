<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="u"   uri="/WEB-INF/u.tld" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetroCars</title>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/headerMenu.jspf"%>
	<fmt:bundle
		basename="ua.dziuhan.utilities.ResourceBundle.Page"
		prefix="tableCars.">
		<table>
			<tr>
				<th></th>
				<td id="sorterCars">
					<form name="sorter" action="${pageContext.request.contextPath}/client/sorterCars">

						<fmt:message key="SortBy" />
						<select name="sortCarsBy" onchange="sorter.submit()">

							<option><c:if test="${not empty sortCarsBy}">
									<fmt:message key="${sortCarsBy}" />
								</c:if>
							</option>
							<optgroup label="Choose sort:"></optgroup>
							<option value="byProducer"><fmt:message key="byProducer" /></option>
							<option value="byProducerReverse"><fmt:message
									key="byProducerReverse" /></option>
							<option value="byPrice"><fmt:message key="byPrice" /></option>
							<option value="byPriceReverse"><fmt:message
									key="byPriceReverse" /></option>
							<option value="byRank"><fmt:message key="byRank" /></option>
							<option value="byRankReverse"><fmt:message
									key="byRankReverse" /></option>
						</select>
						<a	href="${pageContext.request.contextPath}/client/viewTemplateCars=table"><fmt:message	key="Table" /> </a>
						<a	href="${pageContext.request.contextPath}/client/viewTemplateCars=list"><fmt:message	key="List" /> </a>
						<a	href="${pageContext.request.contextPath}/client/viewTemplateCars=Tile"><fmt:message	key="Tile" /> </a>
					</form>
				</td>
			</tr>

			<tr>
				<td id="filterCars">
					<form action="${pageContext.request.contextPath}/client/filterCars" class="center">
						<u:filter-cars></u:filter-cars>
						<input	type="submit" value="<fmt:message key="Filter"/>">
					</form>

				</td>
				<td id="tableCars"><u:carsPageView /></td>
			</tr>
		</table>
	</fmt:bundle>
	<hr>
</body>
</html>