<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<title> ${systemTitle}-首页 </title>
		<%@include file="/WEB-INF/jsp/f/common/resource.jsp" %>
  	</head>
   
  <body>
  		
		<%@include file="/WEB-INF/jsp/f/common/header.jsp" %>
  		
  		<div class="container">
	  		<div class="main-content">
	  		
	  			<div class="module-title" style="margin-top:70px;">
	  				<div class="module-title-div">
	  					<div class="module-title-div-img style-orange">
	  					</div>
	  				</div>
	  			</div>
	  			
	  			
	  			<div class="a-style-warp">
	  				<div>
	  				<c:forEach begin="1" end="9" var="x">
	  					<div class="a-style-item index-${x%3}">
		  					<div class="play-btn"></div>
		  					<a href="">
		  					<img alt="" src="${basePath}resource/f/theme/default/css/img/style-demo.png"/>
		  					</a>
		  					<a href="#">
		  					<span class="a-style-title">激发智慧无限潜能</span>
		  					</a>
		  					<span class="a-style-sub-title">无锡云尚优课教育咨询有限公司</span>
		  				</div>
	  				</c:forEach>
	  				</div>
	  			</div>
	  			
	  			
		  		
	  		</div>
	  		
  		</div>
	  	
	  	<%@include file="/WEB-INF/jsp/f/common/footer.jsp" %>
 		
  </body>
</html>
