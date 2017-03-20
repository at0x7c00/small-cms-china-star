<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="big-banner">
  			<c:if test="${(not empty siteSetting.headerPic) and siteSetting.headerPic.video}">
	  			<div class="video-div">
	  				<video autoplay="autoplay" loop="loop">
	  					<source src="${basePath}resource/video/home-video-bg.mp4" type="video/mp4" >
	  				</video>
	  			</div>
	  			<div class="video-div-mask"></div>
  			</c:if>
  		</div>
		
		<%@ include file="/WEB-INF/jsp/f/common/menu.jsp" %>