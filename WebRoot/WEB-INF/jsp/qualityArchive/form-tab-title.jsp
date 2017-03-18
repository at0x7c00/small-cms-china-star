<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<li>
		<a href="#attachments" data-toggle="tab"><spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.cover"/></a>
	</li>
	<li>
		<a href="#videoOrPicture" data-toggle="tab">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.detailCover"/>
		</a>
	</li>
	<c:if test="${not historyView}">
		<li>
			<a href="#productDisplay" data-toggle="tab" <c:if test="${checkResult['productDisplay'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.productDisplay"/></a>
		</li>
	</c:if>
	<c:if test="${not historyView}">
		<li>
			<a href="#gloryDisplay" data-toggle="tab" <c:if test="${checkResult['gloryDisplay'].changed}">style="color:red;" </c:if>><spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchive.gloryDisplay"/></a>
		</li>
	</c:if>