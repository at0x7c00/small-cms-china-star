<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<c:if test="${not historyView}">
	<li class="active">
		<a href="#headerPics" data-toggle="tab" <c:if test="${checkResult['headerPic'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.chinastar.entity.SiteSetting.headerPic"/></a>
	</li>
		</c:if>
		<c:if test="${not historyView}">
	<li>
		<a href="#infoHeaderPics" data-toggle="tab" <c:if test="${checkResult['infoHeaderPic'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.chinastar.entity.SiteSetting.infoHeaderPic"/></a>
	</li>
		</c:if>