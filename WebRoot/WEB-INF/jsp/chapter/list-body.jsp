<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<td>${tempBean.id}</td>
		<td>
		<strong>${tempBean.title}</strong><br/>
		<ul class="chapter-detail">
		<li>
		<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.creator"/>:${tempBean.creator.chineseName}
		</li>
		<li>
		<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.createTime"/>:<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
		</li>
		<li>
		<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.page"/>:${tempBean.page.name}
		</li>
		<li>
		<spring:message code="props.me.huqiao.smallcms.cms.entity.Chapter.readCount"/>:${tempBean.readCount}
		</li>
		</ul>
		</td>
		<td>
		${tempBean.orderNum}
		</td>
		<td>
		${useStatusMap[tempBean.status]}
		</td>