<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.FriendLink.name"/>
		</th>
		<th align="center" data-sortfield="url" class="${nfn:sortClass(pageBean,'url')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.FriendLink.url"/>
		</th>
		<th align="center" data-sortfield="orderNum" class="${nfn:sortClass(pageBean,'orderNum')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.FriendLink.orderNum"/>
		</th>
		<th align="center" data-sortfield="picture" class="${nfn:sortClass(pageBean,'picture')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.FriendLink.picture"/>
		</th>
		<th align="center" data-sortfield="status" class="${nfn:sortClass(pageBean,'status')}">
			<spring:message code="props.me.huqiao.smallcms.cms.entity.FriendLink.status"/>
		</th>