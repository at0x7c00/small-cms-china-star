<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['title'].changed}">title= "${checkResult['title'].info}";</c:if>
						   >
			<span class="${checkResult['title'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.title"/>:
									<c:out value="${tempBean.title}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['corporateName'].changed}">title= "${checkResult['corporateName'].info}";</c:if>
						   >
			<span class="${checkResult['corporateName'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.corporateName"/>:
									<c:out value="${tempBean.corporateName}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['content'].changed}">title= "${checkResult['content'].info}";</c:if>
						   >
			<span class="${checkResult['content'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.content"/>:
									<c:out value="${tempBean.content}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['video'].changed}">title= "${checkResult['video'].info}";</c:if>
						   >
			<span class="${checkResult['video'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.video"/>:
									${tempBean.video.name}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['creator'].changed}">title= "${checkResult['creator'].info}";</c:if>
						   >
			<span class="${checkResult['creator'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.creator"/>:
									${tempBean.creator.name}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['createTime'].changed}">title= "${checkResult['createTime'].info}";</c:if>
						   >
			<span class="${checkResult['createTime'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.createTime"/>:
									<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['updateTime'].changed}">title= "${checkResult['updateTime'].info}";</c:if>
						   >
			<span class="${checkResult['updateTime'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.updateTime"/>:
									<fmt:formatDate value="${tempBean.updateTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['orderNum'].changed}">title= "${checkResult['orderNum'].info}";</c:if>
						   >
			<span class="${checkResult['orderNum'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.orderNum"/>:
									<c:out value="${tempBean.orderNum}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['status'].changed}">title= "${checkResult['status'].info}";</c:if>
						   >
			<span class="${checkResult['status'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.status"/>:
								${useStatusMap[tempBean.status]}
			</span>
		</label>
	</section>