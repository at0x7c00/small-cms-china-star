<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
				<td>
									${tempBean.creator.manageKey}
				</td>
				<td>
									${tempBean.readCount}
				</td>
				<td>
								<fmt:formatDate value="${tempBean.createTime}" pattern="${applicationScope.EN_YEAR_MONTH_DAY_HOUR_MIN_SEC}"/>
				</td>
				<td>
									${tempBean.title}
				</td>
				<td>
									${tempBean.content}
				</td>
				<td>
									${tempBean.page.name}
				</td>
				<td>
									${tempBean.cover.manageKey}
				</td>
				<td>
									${tempBean.orderNum}
				</td>
				<td>
									${useStatusMap[tempBean.status]}
				</td>