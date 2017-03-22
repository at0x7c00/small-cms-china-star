<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<li>
		<a href="#covers" data-toggle="tab" <c:if test="${checkResult['cover'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.cover"/></a>
	</li>
		<c:if test="${not historyView}">
	<li>
		<a href="#videos" data-toggle="tab" <c:if test="${checkResult['video'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.video"/></a>
	</li>
		</c:if>