<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
				<td>
									${tempBean.name}
				</td>
				<td>
									${tempBean.tel}
				</td>
				<td>
									${tempBean.address}
				</td>
				<td>
								<fmt:formatDate value="${tempBean.coroprateFrom}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
				</td>
				<td>
								<fmt:formatDate value="${tempBean.coroprateTo}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
				</td>
				<td>
									${tempBean.certFile.manageKey}
				</td>