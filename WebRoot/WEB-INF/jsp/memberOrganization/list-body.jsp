<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>${tempBean.id}</td>
		<td>
		${tempBean.name}
		</td>
			<td><fmt:formatDate value="${tempBean.corporateFrom}" pattern="${applicationScope.EN_YEAR_MONTH_DAY}"/></td>
			<td><fmt:formatDate value="${tempBean.corporateTo}" pattern="${applicationScope.EN_YEAR_MONTH_DAY}"/></td>
			<td>${tempBean.certFile.name}</td>
			<td>${useStatusMap[tempBean.status]}</td>