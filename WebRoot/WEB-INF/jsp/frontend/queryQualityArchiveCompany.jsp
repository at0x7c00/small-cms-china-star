<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<c:choose>
	<c:when test="${ empty tempBean}">
		没有查询到结果.
	</c:when>
	<c:otherwise>
		<table width="100%" cellpadding="5px">
 				<tr>
 					<td width="165px" style="text-align: right">公司名称：</td>
 					<td>
 						<strong style="color:#56a5f9;">${tempBean.name}</strong>
 					</td>
 				</tr>
 				<tr>
 					<td width="165px" style="text-align: right">法人代表：</td>
 					<td>
 						${tempBean.lawPerson }
 					</td>
 				</tr>
 				<tr>
 					<td width="165px" style="text-align: right">注册资金：</td>
 					<td>
 						${tempBean.registerMoney }万元
 					</td>
 				</tr>
 				<tr>
 					<td width="165px" style="text-align: right;vertical-align: top;">企业所在地：</td>
 					<td>
 						${tempBean.address }
 					</td>
 				</tr>
 				<tr>
 					<td width="165px" style="text-align: right;vertical-align: top;">经营范围：</td>
 					<td>
 						${tempBean.tradeScope }
 					</td>
 				</tr>
 				<tr>
 					<td width="165px" style="text-align: right">所属服务中心：</td>
 					<td>
 						${tempBean.serviceCenter }
 					</td>
 				</tr>
 				<tr>
 					<td width="175px" style="text-align: right">企业资质初步审核状态：</td>
 					<td>
 						${tempBean.auditStatus }
 					</td>
 				</tr>
 			</table>
	</c:otherwise>
</c:choose>
