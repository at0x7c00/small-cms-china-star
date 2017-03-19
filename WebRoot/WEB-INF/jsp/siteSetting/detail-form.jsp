<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['headerPic'].changed}">title= "${checkResult['headerPic'].info}";</c:if>
						   >
			<span class="${checkResult['headerPic'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.SiteSetting.headerPic"/>:
									${tempBean.headerPic.name}
			</span>
		</label>
	</section>
	<section class="col col-3">
		<label class="input"
						   <c:if test="${checkResult['infoHeaderPic'].changed}">title= "${checkResult['infoHeaderPic'].info}";</c:if>
						   >
			<span class="${checkResult['infoHeaderPic'].changed ? 'change-markup':''}">
						<spring:message code="props.me.huqiao.smallcms.chinastar.entity.SiteSetting.infoHeaderPic"/>:
									${tempBean.infoHeaderPic.name}
			</span>
		</label>
	</section>