<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<%
	pageContext.setAttribute("url", request.getParameter("url"));
	pageContext.setAttribute("params", request.getParameter("params"));
%>
<div class="page-bar">
	<c:choose>
		<c:when test="${page.pageNum>1}">
			<a href="${basePath}${url}?pageNum=${page.pageNum-1}&${params }#content" style="padding-left:15px;padding-right:15px;"><i class="fa fa-angle-left"></i></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:void(0);" class="no-hover" style="border-color:#ddd;color:#ddd;padding-left:15px;padding-right:15px;"><i class="fa fa-angle-left"></i></a>
		</c:otherwise>
	</c:choose>
	<c:forEach items="${page.pageBarIndex}" var="x"> 
		<a href="${basePath}${url}?pageNum=${x}&${params }#content" class="${x eq page.pageNum ? 'active':'' }">${x}</a>
	</c:forEach>
	
	<c:choose>
		<c:when test="${page.pageNum<page.countPage}">
			<a href="${basePath}${url}?pageNum=${page.pageNum+1}&${params }#content" style="padding-left:15px;padding-right:15px;"><i class="fa fa-angle-right"></i></a>
		</c:when>
		<c:otherwise>
			<a href="javascript:void(0);" class="no-hover" style="border-color:#ddd;color:#ddd;padding-left:15px;padding-right:15px;"><i class="fa fa-angle-right"></i></a>
		</c:otherwise>
	</c:choose>
</div>