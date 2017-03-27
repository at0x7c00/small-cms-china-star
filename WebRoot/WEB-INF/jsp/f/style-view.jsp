<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<div>
<video id="my-video" class="video-js" controls preload="auto" width="1042" height="580"
 poster="${basePath}filee/viewPic.do?manageKey=${style.cover.manageKey}" data-setup="{}">
   <source src="${basePath}uploads/${style.video.manageKey}" type='video/mp4'>
   <p class="vjs-no-js">
     To view this video please enable JavaScript, and consider upgrading to a web browser that
     <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
   </p>
 </video>
 
	
 <div style="height:40px;">
 		<span style="font-size:17px;float:left;margin:15px 20px;">${style.title }</span>
 		<span style="font-size:17px;float:right;margin:15px 20px;">${style.corporateName}</span>
 </div>
</div>
