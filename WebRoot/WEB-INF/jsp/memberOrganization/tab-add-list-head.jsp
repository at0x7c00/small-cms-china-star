<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.MemberOrganization.name"/>
		</th>
		<th align="center" data-sortfield="corporateFrom" class="${nfn:sortClass(pageBean,'corporateFrom')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.MemberOrganization.corporateFrom"/>
		</th>
		<th align="center" data-sortfield="corporateTo" class="${nfn:sortClass(pageBean,'corporateTo')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.MemberOrganization.corporateTo"/>
		</th>
		<th align="center" data-sortfield="certFile" class="${nfn:sortClass(pageBean,'certFile')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.MemberOrganization.certFile"/>
		</th>