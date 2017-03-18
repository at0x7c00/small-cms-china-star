<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<th align="center" data-sortfield="title" class="${nfn:sortClass(pageBean,'title')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.title"/>
		</th>
		<th align="center" data-sortfield="url" class="${nfn:sortClass(pageBean,'url')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.url"/>
		</th>
		<th align="center" data-sortfield="picture" class="${nfn:sortClass(pageBean,'picture')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.picture"/>
		</th>
		<th align="center" data-sortfield="orderNum" class="${nfn:sortClass(pageBean,'orderNum')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.orderNum"/>
		</th>
		<th align="center" data-sortfield="status" class="${nfn:sortClass(pageBean,'status')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.Advertisement.status"/>
		</th>