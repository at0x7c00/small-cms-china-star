<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<c:if test="${not historyView}">
	<li>
		<a href="#covers" data-toggle="tab" <c:if test="${checkResult['cover'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.cover"/></a>
	</li>
		</c:if>