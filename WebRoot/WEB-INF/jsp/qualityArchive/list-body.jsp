<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>${tempBean.id}</td>
		<td>
		${tempBean.title}
		</td>
			<td>${tempBean.detailCover.name}</td>
			<td>${tempBean.creator.chineseName}</td>
			<td><fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/></td>
		<td>
		${tempBean.orderNum}
		</td>
			<td><fmt:formatDate value="${tempBean.readCount}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/></td>
		<td>
		${useStatusMap[tempBean.status]}
		</td>