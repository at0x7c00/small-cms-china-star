<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
				<td>
									${tempBean.name}
				</td>
				<td>
									${tempBean.lawPerson}
				</td>
				<td>
									${tempBean.registerMoney}
				</td>
				<td>
									${tempBean.address}
				</td>
				<td>
									${tempBean.tradeScope}
				</td>
				<td>
									${tempBean.serviceCenter}
				</td>
				<td>
									${tempBean.auditStatus}
				</td>
				<td>
									${useStatusMap[tempBean.status]}
				</td>