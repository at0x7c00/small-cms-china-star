<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<%
	pageContext.setAttribute("url", request.getParameter("url"));
	pageContext.setAttribute("params", request.getParameter("params"));
%>
<div class="page-bar" style="margin-bottom:80px;">
	<c:choose>
		<c:when test="${page.pageNum>1}">
			<a href="${basePath}${url}?pageNum=${page.pageNum-1}&${params }#content" style="padding-left:15px;padding-right:15px;">
				<span>
				<i class="fa fa-angle-double-left"></i>
				</span>
				<span class="right"></span>
			</a>
		</c:when>
		<c:otherwise>
				<a href="javascript:void(0);" class="no-hover" >
				<span>
				<i class="fa fa-angle-double-left"></i>
				</span>
				<span class="right"></span>
				</a>
		</c:otherwise>
	</c:choose>
	<c:forEach items="${page.pageBarIndex}" var="x"> 
				<a href="${basePath}${url}?pageNum=${x}&${params }#content" class="${x eq page.pageNum ? 'active':'' }">
				<span>
				${x}
				</span>
				<span class="right"></span>
				</a>
	</c:forEach>
	
	<c:choose>
		<c:when test="${page.pageNum<page.countPage}">
				<a href="${basePath}${url}?pageNum=${page.pageNum+1}&${params }#content">
				<span>
					<i class="fa fa-angle-double-right"></i>
				</span>
				<span class="right"></span>
				</a>
		</c:when>
		<c:otherwise>
			<span>
				<a href="javascript:void(0);" class="no-hover" >
				<span>
				<i class="fa fa-angle-double-right"></i>
				</span>
				<span class="right"></span>
				</a>
			</span>
		</c:otherwise>
	</c:choose>
</div>