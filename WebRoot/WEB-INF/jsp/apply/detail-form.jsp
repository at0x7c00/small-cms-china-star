<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-12">
		<label class="input">
			<span class="">
						申请时间:
						<fmt:formatDate value="${tempBean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</span>
		</label>
	</section>
	<section class="col col-12">
		<label class="input"
						   <c:if test="${checkResult['name'].changed}">title= "${checkResult['name'].info}";</c:if>
						   >
			<span class="${checkResult['name'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.name"/>:
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
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.address"/>:
									<c:out value="${tempBean.address}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['contact'].changed}">title= "${checkResult['contact'].info}";</c:if>
						   >
			<span class="${checkResult['contact'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.contact"/>:
									<c:out value="${tempBean.contact}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['tel'].changed}">title= "${checkResult['tel'].info}";</c:if>
						   >
			<span class="${checkResult['tel'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.tel"/>:
									<c:out value="${tempBean.tel}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['registMoney'].changed}">title= "${checkResult['registMoney'].info}";</c:if>
						   >
			<span class="${checkResult['registMoney'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.registMoney"/>:
									<c:out value="${tempBean.registMoney}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['industry'].changed}">title= "${checkResult['industry'].info}";</c:if>
						   >
			<span class="${checkResult['industry'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.industry"/>:
									<c:out value="${tempBean.industry}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['bandNum'].changed}">title= "${checkResult['bandNum'].info}";</c:if>
						   >
			<span class="${checkResult['bandNum'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.bandNum"/>:
									<c:out value="${tempBean.bandNum}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['status'].changed}">title= "${checkResult['status'].info}";</c:if>
						   >
			<span class="${checkResult['status'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.status"/>:
									<c:out value="${useStatusMap[tempBean.status]}"/>
			</span>
		</label>
	</section>
	<section class="col col-12">
		<label class="input"
						   <c:if test="${checkResult['remark'].changed}">title= "${checkResult['remark'].info}";</c:if>
						   >
			<span class="${checkResult['remark'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.remark"/>:
									<c:out value="${tempBean.remark}"/>
			</span>
		</label>
	</section>