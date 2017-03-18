<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['workNum'].changed}">title= "${checkResult['workNum'].info}";</c:if>
						   >
			<span class="${checkResult['workNum'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.workNum"/>:
									<c:out value="${tempBean.workNum}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.name"/>:
									<c:out value="${tempBean.name}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['area'].changed}">title= "${checkResult['area'].info}";</c:if>
						   >
			<span class="${checkResult['area'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.area"/>:
									<c:out value="${tempBean.area}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['job'].changed}">title= "${checkResult['job'].info}";</c:if>
						   >
			<span class="${checkResult['job'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.job"/>:
									<c:out value="${tempBean.job}"/>
			</span>
		</label>
	</section>