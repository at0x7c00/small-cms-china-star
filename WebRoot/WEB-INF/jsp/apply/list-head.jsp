<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.name"/>
		</th>
			<th align="center" data-sortfield="contact" class="${nfn:sortClass(pageBean,'contact')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.contact"/>
		</th>
			<th align="center" data-sortfield="tel" class="${nfn:sortClass(pageBean,'tel')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.tel"/>
		</th>
			<th align="center" data-sortfield="remark" class="${nfn:sortClass(pageBean,'remark')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.remark"/>
		</th>
			<th align="center" data-sortfield="status" class="${nfn:sortClass(pageBean,'status')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.Apply.status"/>
		</th>