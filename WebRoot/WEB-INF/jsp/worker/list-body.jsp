<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<td>${tempBean.id}</td>
		<td>
		${tempBean.workNum}
		</td>
		<td>
			<c:if test="${not empty tempBean.photoFile }">
			<a href="${basePasth }filee/viewPic.do?manageKey=${tempBean.photoFile.manageKey}" target="_blank">
				<img alt="" src="${basePasth }filee/viewPic.do?manageKey=${tempBean.photoFile.manageKey}" class="table-pic"/>
			</a>
			</c:if>
		</td>
		<td>
		${tempBean.name}
		</td>
		<td>
		${tempBean.area}
		</td>
		<td>
		${tempBean.job}
		</td>
		<td>
		${useStatusMap[tempBean.status]}
		</td>