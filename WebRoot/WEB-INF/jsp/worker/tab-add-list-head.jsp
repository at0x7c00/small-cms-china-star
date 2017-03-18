<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
		<th align="center" data-sortfield="workNum" class="${nfn:sortClass(pageBean,'workNum')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.workNum"/>
		</th>
		<th align="center" data-sortfield="photoFile" class="${nfn:sortClass(pageBean,'photoFile')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.photoFile"/>
		</th>
		<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.name"/>
		</th>
		<th align="center" data-sortfield="area" class="${nfn:sortClass(pageBean,'area')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.area"/>
		</th>
		<th align="center" data-sortfield="job" class="${nfn:sortClass(pageBean,'job')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Worker.job"/>
		</th>