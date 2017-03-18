<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-12">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.name"/>:
									<strong>
									<c:out value="${tempBean.name}"/>
									</strong>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['lawPerson'].changed}">title= "${checkResult['lawPerson'].info}";</c:if>
						   >
			<span class="${checkResult['lawPerson'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.lawPerson"/>:
									<c:out value="${tempBean.lawPerson}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['registerMoney'].changed}">title= "${checkResult['registerMoney'].info}";</c:if>
						   >
			<span class="${checkResult['registerMoney'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.registerMoney"/>:
									<c:out value="${tempBean.registerMoney}"/>
			</span>
		</label>
	</section>
	<section class="col col-12">
		<label class="input"
						   <c:if test="${checkResult['address'].changed}">title= "${checkResult['address'].info}";</c:if>
						   >
			<span class="${checkResult['address'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.address"/>:
									<c:out value="${tempBean.address}"/>
			</span>
		</label>
	</section>
	<section class="col col-12">
		<label class="input"
						   <c:if test="${checkResult['tradeScope'].changed}">title= "${checkResult['tradeScope'].info}";</c:if>
						   >
			<span class="${checkResult['tradeScope'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.tradeScope"/>:
									<c:out value="${tempBean.tradeScope}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['serviceCenter'].changed}">title= "${checkResult['serviceCenter'].info}";</c:if>
						   >
			<span class="${checkResult['serviceCenter'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.serviceCenter"/>:
									<c:out value="${tempBean.serviceCenter}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['auditStatus'].changed}">title= "${checkResult['auditStatus'].info}";</c:if>
						   >
			<span class="${checkResult['auditStatus'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.auditStatus"/>:
									<c:out value="${tempBean.auditStatus}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['status'].changed}">title= "${checkResult['status'].info}";</c:if>
						   >
			<span class="${checkResult['status'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.QualityArchiveCompany.status"/>:
								${useStatusMap[tempBean.status]}
			</span>
		</label>
	</section>