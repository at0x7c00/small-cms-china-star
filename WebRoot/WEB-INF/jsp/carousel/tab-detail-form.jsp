<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
				<td>
									${tempBean.picture.manageKey}
				</td>
				<td>
									${tempBean.url}
				</td>
				<td>
									${tempBean.orderNum}
				</td>
				<td>
									${useStatusMap[tempBean.status]}
				</td>