<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-12">
		<label class="input"
						   <c:if test="${checkResult['title'].changed}">title= "${checkResult['title'].info}";</c:if>
						   >
			<span class="${checkResult['title'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.title"/>:
									<c:out value="${tempBean.title}"/>
			</span>
		</label>
	</section>
	<section class="col col-12">
		<label class="input"
						   <c:if test="${checkResult['url'].changed}">title= "${checkResult['url'].info}";</c:if>
						   >
			<span class="${checkResult['url'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.url"/>:
									<c:out value="${tempBean.url}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['orderNum'].changed}">title= "${checkResult['orderNum'].info}";</c:if>
						   >
			<span class="${checkResult['orderNum'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.orderNum"/>:
									<c:out value="${tempBean.orderNum}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['status'].changed}">title= "${checkResult['status'].info}";</c:if>
						   >
			<span class="${checkResult['status'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.status"/>:
								${useStatusMap[tempBean.status]}
			</span>
		</label>
	</section>