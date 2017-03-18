<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<c:choose>
	<c:when test="${ empty tempBean}">
		没有查询到结果.
	</c:when>
	<c:otherwise>
	
		<table width="100%" border="0" style="margin-top:30px;">
			<tr>
				<td>
					
					<table width="100%" cellpadding="16px" border="0">
		 				<tr>
		 					<td width="150px" style="text-align: right">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
		 					<td>
		 						${tempBean.workNum }
		 					</td>
		 				</tr>
		 				<tr>
		 					<td width="150px" style="text-align: right">员工姓名：</td>
		 					<td>
		 						<strong style="color:#56a5f9;">${tempBean.name}</strong>
		 					</td>
		 				</tr>
		 				<tr>
		 					<td width="150px" style="text-align: right">所属区域：</td>
		 					<td>
		 						${tempBean.area }
		 					</td>
		 				</tr>
		 				<tr>
		 					<td width="150px" style="text-align: right">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</td>
		 					<td>
		 						${tempBean.job }
		 					</td>
		 				</tr>
		 			</table>
				</td>
				<td>
 						<c:if test="${not empty tempBean.photoFile }">
 						<img alt="" src="${basePath}filee/viewPic.do?manageKey=${tempBean.photoFile.manageKey}" style="height:182px;width:145px;"/>
 						</c:if>
				</td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>
