<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-12">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.name"/>:
									<strong>
									<c:out value="${tempBean.name}"/>
									</strong>
			</span>
		</label>
	</section>
	<section class="col col-12">
		<label class="input"
						   <c:if test="${checkResult['address'].changed}">title= "${checkResult['address'].info}";</c:if>
						   >
			<span class="${checkResult['address'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.address"/>:
									<c:out value="${tempBean.address}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['tel'].changed}">title= "${checkResult['tel'].info}";</c:if>
						   >
			<span class="${checkResult['tel'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.tel"/>:
									<c:out value="${tempBean.tel}"/>
			</span>
		</label>
	</section>
	
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['coroprateFrom'].changed}">title= "${checkResult['coroprateFrom'].info}";</c:if>
						   >
			<span class="${checkResult['coroprateFrom'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.coroprateFrom"/>:
									<fmt:formatDate value="${tempBean.coroprateFrom}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['coroprateTo'].changed}">title= "${checkResult['coroprateTo'].info}";</c:if>
						   >
			<span class="${checkResult['coroprateTo'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.coroprateTo"/>:
									<fmt:formatDate value="${tempBean.coroprateTo}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
