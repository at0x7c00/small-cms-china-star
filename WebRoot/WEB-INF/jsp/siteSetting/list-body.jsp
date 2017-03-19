<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
			<td>
				<c:choose>
					<c:when test="${not empty tempBean.headerPic }">
						<c:choose>
						<c:when test="${tempBean.headerPic.picture}">
						<img src="${basePath}filee/viewPic.do?manageKey=${tempBean.headerPic.manageKey}" class="table-pic-lg hover-able"/>
						</c:when>
						<c:when test="${tempBean.headerPic.video }">
							视频
						</c:when>
						</c:choose>
					</c:when>
					<c:otherwise>
						默认图片
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${not empty tempBean.infoHeaderPic }">
						<img src="${basePath}filee/viewPic.do?manageKey=${tempBean.infoHeaderPic.manageKey}" class="table-pic-lg hover-able"/>
					</c:when>
					<c:otherwise>
						默认图片
					</c:otherwise>
				</c:choose>
			</td>
			<td style="vertical-align: middle;">
				<A href="${basePath}siteSetting/update.do?manageKey=${tempBean.manageKey}" class="btn btn-primary" style="padding:5px 10px;" target="dialogTodo" title="修改网站设置">
				<i class="fa fa-cog"></i> 修改
				</A>
			</td>