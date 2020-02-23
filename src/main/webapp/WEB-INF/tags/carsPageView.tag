<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/u.tld" prefix="u"%>
<fmt:setLocale value="${locale}" />
<c:if test="${empty indexPage}">
	<c:set var="indexPage" value="1" />
</c:if>
<u:pageView indexPage="${indexPage}" list="${cars}" />
<c:choose>
	<c:when test="${viewTemplateCars=='table'}">
		<u:carsViewTable />
	</c:when>
	<c:when test="${viewTemplateCars=='list'}">
		<u:carsViewList />
	</c:when>
	<c:when test="${viewTemplateCars=='Tile'}">
		<u:carsViewLargeIcons />
	</c:when>
	<c:otherwise>
		<u:carsViewTable />
	</c:otherwise>
</c:choose>
<div class="center">
	<a href="changePageView=${indexFirstPage}">${indexFirstPage}</a>
	<a href="changePageView=${indexPreviousPage}">${indexPreviousPage}</a>
	<b>${indexPage} </b>
	<a href="changePageView=${indexNextPage}">${indexNextPage}</a>
	<a href="changePageView=${indexLastPage}">${indexLastPage}</a>
</div>

