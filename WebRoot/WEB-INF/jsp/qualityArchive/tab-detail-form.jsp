<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
				<td>
									${tempBean.title}
				</td>
				<td>
									${tempBean.content}
				</td>
				<td>
									${tempBean.detailCover.manageKey}
				</td>
				<td>
									${tempBean.creator.manageKey}
				</td>
				<td>
								<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
				</td>
				<td>
									${tempBean.orderNum}
				</td>
				<td>
								<fmt:formatDate value="${tempBean.readCount}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
				</td>
				<td>
									${useStatusMap[tempBean.status]}
				</td>