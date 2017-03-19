<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['title'].changed}">title= "${checkResult['title'].info}";</c:if>
						   >
			<span class="${checkResult['title'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.title"/>:
									<c:out value="${tempBean.title}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['content'].changed}">title= "${checkResult['content'].info}";</c:if>
						   >
			<span class="${checkResult['content'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.content"/>:
									<c:out value="${tempBean.content}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['createTime'].changed}">title= "${checkResult['createTime'].info}";</c:if>
						   >
			<span class="${checkResult['createTime'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.createTime"/>:
									<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['updateTime'].changed}">title= "${checkResult['updateTime'].info}";</c:if>
						   >
			<span class="${checkResult['updateTime'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.updateTime"/>:
									<fmt:formatDate value="${tempBean.updateTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['creator'].changed}">title= "${checkResult['creator'].info}";</c:if>
						   >
			<span class="${checkResult['creator'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.creator"/>:
									${tempBean.creator.name}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['cover'].changed}">title= "${checkResult['cover'].info}";</c:if>
						   >
			<span class="${checkResult['cover'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.cover"/>:
									${tempBean.cover.name}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['orderNum'].changed}">title= "${checkResult['orderNum'].info}";</c:if>
						   >
			<span class="${checkResult['orderNum'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.orderNum"/>:
									<c:out value="${tempBean.orderNum}"/>
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['status'].changed}">title= "${checkResult['status'].info}";</c:if>
						   >
			<span class="${checkResult['status'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.status"/>:
								${useStatusMap[tempBean.status]}
			</span>
		</label>
	</section>