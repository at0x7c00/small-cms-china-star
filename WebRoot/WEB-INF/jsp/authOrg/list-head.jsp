<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<th  data-sortfield="id" class="${nfn:sortClass(pageBean,'id')}"><spring:message code="base.function.table.head.no"/></th>
			<th align="center" data-sortfield="name" class="${nfn:sortClass(pageBean,'name')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.name"/>
		</th>
			<th align="center" data-sortfield="tel" class="${nfn:sortClass(pageBean,'tel')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.tel"/>
		</th>
			<th align="center" data-sortfield="address" class="${nfn:sortClass(pageBean,'address')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.address"/>
		</th>
			<th align="center" data-sortfield="coroprateFrom" class="${nfn:sortClass(pageBean,'coroprateFrom')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.coroprateFrom"/>
		</th>
			<th align="center" data-sortfield="coroprateTo" class="${nfn:sortClass(pageBean,'coroprateTo')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.coroprateTo"/>
		</th>
			<th align="center" data-sortfield="certFile" class="${nfn:sortClass(pageBean,'certFile')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.certFile"/>
		</th>
			<th align="center" data-sortfield="status" class="${nfn:sortClass(pageBean,'status')}">
			<spring:message code="props.me.huqiao.smallcms.ppll.entity.AuthOrg.status"/>
		</th>