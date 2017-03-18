<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>${tempBean.id}</td>
			<td>
			<a href="${basePath}filee/viewPic.do?manageKey=${tempBean.picture.manageKey}" target="_blank">
				<img alt="" src="${basePath}filee/viewPic.do?manageKey=${tempBean.picture.manageKey}" class="table-pic hover-able"/>
			</a>
			</td>
		<td>
		<strong>${tempBean.title}</strong>
		<ul class="chapter-detail">
			<li><spring:message code="props.me.huqiao.smallcms.cms.entity.Carousel.url"/>:${tempBean.url}</li>
		</ul>
		</td>
		<td>
		${tempBean.orderNum}
		</td>
		<td>
		${useStatusMap[tempBean.status]}
		</td>