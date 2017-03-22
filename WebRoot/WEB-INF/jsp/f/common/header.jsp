<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="big-banner">
		<c:choose>
  			<c:when test="${(not empty siteSetting.headerPic) and siteSetting.headerPic.video}">
	  			<div class="video-div">
	  				<video autoplay="autoplay" loop="loop">
	  					<source src="${basePath}filee/downloadFile.do?key=${siteSetting.headerPic.manageKey}" type="video/mp4" >
	  				</video>
	  			</div>
	  			<div class="video-div-mask"></div>
  			</c:when>
  		</c:choose>
  		</div>
		
		<%@ include file="/WEB-INF/jsp/f/common/menu.jsp" %>