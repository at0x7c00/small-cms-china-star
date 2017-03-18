<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.WebPage.name"/>
		</th>
		<th align="center" data-sortfield="key" class="${nfn:sortClass(pageBean,'key')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.WebPage.key"/>
		</th>
		<th align="center" data-sortfield="orderNum" class="${nfn:sortClass(pageBean,'orderNum')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.WebPage.orderNum"/>
		</th>
		<th align="center" data-sortfield="status" class="${nfn:sortClass(pageBean,'status')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.WebPage.status"/>
		</th>