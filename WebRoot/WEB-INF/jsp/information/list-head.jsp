<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="title" class="${nfn:sortClass(pageBean,'title')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.title"/>
		</th>
			<th align="center" data-sortfield="createTime" class="${nfn:sortClass(pageBean,'createTime')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.createTime"/>
		</th>
			<th align="center" data-sortfield="updateTime" class="${nfn:sortClass(pageBean,'updateTime')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.updateTime"/>
		</th>
			<th align="center" data-sortfield="creator" class="${nfn:sortClass(pageBean,'creator')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.creator"/>
		</th>
			<th align="center" data-sortfield="cover" class="${nfn:sortClass(pageBean,'cover')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.cover"/>
		</th>
			<th align="center" data-sortfield="orderNum" class="${nfn:sortClass(pageBean,'orderNum')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.orderNum"/>
		</th>
			<th align="center" data-sortfield="status" class="${nfn:sortClass(pageBean,'status')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.Information.status"/>
		</th>