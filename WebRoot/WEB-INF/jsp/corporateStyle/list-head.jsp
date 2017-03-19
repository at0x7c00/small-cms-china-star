<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="title" class="${nfn:sortClass(pageBean,'title')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.title"/>
		</th>
			<th align="center" data-sortfield="corporateName" class="${nfn:sortClass(pageBean,'corporateName')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.corporateName"/>
		</th>
			<th align="center" data-sortfield="creator" class="${nfn:sortClass(pageBean,'creator')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.creator"/>
		</th>
			<th align="center" data-sortfield="createTime" class="${nfn:sortClass(pageBean,'createTime')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.createTime"/>
		</th>
			<th align="center" data-sortfield="updateTime" class="${nfn:sortClass(pageBean,'updateTime')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.updateTime"/>
		</th>
			<th align="center" data-sortfield="orderNum" class="${nfn:sortClass(pageBean,'orderNum')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.orderNum"/>
		</th>
			<th align="center" data-sortfield="status" class="${nfn:sortClass(pageBean,'status')}">
			<spring:message code="props.me.huqiao.smallcms.chinastar.entity.CorporateStyle.status"/>
		</th>